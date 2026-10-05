package com.example.banderas.Screens

import android.graphics.Point
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
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
fun BanderaScreen(modifier: Modifier = Modifier)
{
    val blueCuba = colorResource(R.color.BlueCuba);
    val redCuba = colorResource(R.color.RedCuba);

    Canvas(modifier = modifier.fillMaxSize())
    {
        val stripe = size.height / 5f;

        for (i in 0 until 5)
        {
            if (i % 2 == 0)
                drawRect(
                    color = blueCuba,
                    topLeft = Offset(0f, i * stripe),
                    size = Size(size.width, stripe)
                )

        }

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
