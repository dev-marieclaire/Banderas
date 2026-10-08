package com.example.banderas.Screens

import android.graphics.Point
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R
import kotlin.io.path.Path
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun starPath(
    posX: Float,
    posY: Float,
    radius: Float,
    rotation: Float = 0f
): Path {
    val path = Path()

    val points = 5
    val stepDeg = 360f / (points * 2)   // 36°
    val innerRadius = radius / 2.5f     // tweak this ratio to taste

    for (i in 0 until points * 2) {     // 10 vertices
        val angleDeg = rotation - 90 + i * stepDeg
        val angleRad = angleDeg * (PI / 180.0)

        val r = if (i % 2 == 0) radius else innerRadius

        val x = posX + r * cos(angleRad).toFloat()
        val y = posY + r * sin(angleRad).toFloat()

        if (i == 0) path.moveTo(x, y)
        else path.lineTo(x, y)
    }

    path.close()
    return path
}

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    val blueCuba = colorResource(R.color.BlueCuba)
    val redCuba = colorResource(R.color.RedCuba)

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val stripeHeight = maxHeight / 5

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val refs = List(5) { createRef() }

            refs.forEachIndexed { i, ref ->
                Box(
                    modifier = Modifier
                        .height(stripeHeight)
                        .background(if (i % 2 == 0) blueCuba else Color.White)
                        .constrainAs(ref) {
                            top.linkTo(if (i == 0) parent.top else refs[i - 1].bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)

                            width = Dimension.fillToConstraints
                        }
                )
            }
        }
    }

    Canvas(modifier = modifier.fillMaxSize())
    {
        val triWidth = size.width * 0.38f;
        val trianglePath = Path().apply {
            moveTo(0f, 0f);
            lineTo(triWidth, size.height / 2f);
            lineTo(0f, size.height);
            close();
        }
        drawPath(trianglePath, redCuba)

        val star = starPath(
            size.width / 7f,
            size.height / 2f,
            radius = size.minDimension / 8f
        )

        drawPath(star, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.fillMaxSize())
    }
}
