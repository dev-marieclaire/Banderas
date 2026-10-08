package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

fun starPath(
    posX: Float,
    posY: Float,
    radius: Float,
    rotation: Float = 0f,
    points: Int = 5,
    innerRatio: Float = 0.382f
): Path {
    val path = Path()
    val stepDeg = 360f / (points * 2)

    for (i in 0 until points * 2) {
        val angleDeg = rotation - 90f + i * stepDeg
        val angleRad = angleDeg * (PI / 180.0)
        val r = if (i % 2 == 0) radius else radius * innerRatio
        val x = posX + r * cos(angleRad).toFloat()
        val y = posY + r * sin(angleRad).toFloat()
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
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
fun BanderaScreen(modifier: Modifier = Modifier) {
    val negro    = Color.Black
    val rojo     = Color(0xFFCE1126)
    val blanco   = Color.White
    val amarillo = Color(0xFFFCD116)

    Canvas(modifier = modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height
        drawRect(rojo)
        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(w, h)
            lineTo(0f, h)
            close()
        }
        drawPath(path, negro)

        drawPath(starPath(size.width * 0.75f, size.height / 3f, 128f, 45f, 6), amarillo)

        drawPath(starPath(size.width / 4f, size.height * 0.45f, 48f, 0f, 5), blanco)
        drawPath(starPath(size.width * 2 / 12f, size.height * 0.60f, 48f, 0f, 5), blanco)
        drawPath(starPath(size.width * 4 / 12f, size.height * 0.60f, 48f, 0f, 5), blanco)
        drawPath(starPath(size.width / 4f, size.height * 0.8f, 48f, 0f, 5), blanco)
        drawPath(starPath(size.width * 0.3f, size.height * 0.7f, 24f, 0f, 5), blanco)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.aspectRatio(4 / 3f))
    }
}
