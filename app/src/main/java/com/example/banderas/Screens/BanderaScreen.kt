package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R
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

val StarShape = GenericShape { size, _ ->
    val cx = size.width / 2f
    val cy = size.height / 2f
    val outerR = minOf(cx, cy)
    val innerR = outerR * 0.4f
    var angle = -PI / 2

    moveTo(cx + outerR * cos(angle).toFloat(), cy + outerR * sin(angle).toFloat())

    for (i in 1..10) {
        angle += PI / 5
        val r = if (i % 2 == 0) outerR else innerR
        lineTo(cx + r * cos(angle).toFloat(), cy + r * sin(angle).toFloat())
    }
    close()
}

@Composable
fun BanderaScreen(modifier: Modifier = Modifier)
{
    val redTurkey = colorResource(R.color.RedTurkey);

    Canvas(modifier = modifier.fillMaxSize())
    {
        drawRect(color = redTurkey);

        val cy = size.height / 2f
        val rOut = size.height * 0.30f
        drawCircle(
            color = Color.White, radius = rOut,
            center = Offset(size.width * 0.38f, cy)
        )

        drawCircle(
            color = Color(0xFFE30A17), radius = size.height * 0.24f,
            center = Offset(size.width * 0.38f + size.height * 0.09f, cy)
        )

        val star = starPath(size.width * 5 / 8f, size.height / 2f, 96f);
        drawPath(star, color = Color.White);
    }
}
@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.aspectRatio(4 / 3f))
    }
}
