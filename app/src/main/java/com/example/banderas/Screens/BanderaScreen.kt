package com.example.banderas.Screens

import android.R.attr.height
import android.R.attr.width
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderas.R
import java.nio.file.Files.size
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
@Composable
fun BanderaScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val rojo     = colorResource(R.color.RedUK)
    val blanco   = Color.White
    val azul = colorResource(R.color.BlueUK)

    val w = width
    val h = height

    // Top right corner
    Canvas(modifier = modifier)
    {
        val w = size.width / 2f;
        val h = size.height / 2f;

        drawRect(azul)

        fun drawQuadrant(x: Float, y: Float, mirror_x: Boolean, mirror_y: Boolean)
        {
            val angle = Math.toDegrees(
                atan2(size.height.toDouble(), size.width.toDouble())
            ).toFloat()

            val hy = hypot(size.width, size.height)

            val effective_angle = if (mirror_x) -angle else angle
            withTransform({
                translate(
                    left = if (mirror_x) size.width else 0f,
                    top = y
                )
                if (mirror_x) scale(scaleX = -1f, scaleY = 1f, pivot = Offset.Zero)
            })
            {
                val localCenter = Offset(w / 2f, h / 2f)
                rotate(degrees = if (mirror_y) -angle else angle, pivot = localCenter)
                {
                    drawRect(
                        blanco,
                        Offset(-w, h / 2f - 60f),
                        Size(w * 1.95f, 120f)
                    )
                }
                rotate(degrees = if (mirror_y) -angle else angle, pivot = localCenter)
                {
                    drawRect(
                        rojo,
                        Offset(-w, if (mirror_x) h / 2f - 30f else h / 2f - 10f),
                        Size(w * 1.95f, 40f)
                    )
                }
            }

            // Línea vertical
            drawRect(
                blanco,
                topLeft = Offset(if (mirror_x) x else x + w * 5f / 6f, y),
                size = Size(w / 6f, h)
            )

            drawRect(
                rojo,
                topLeft = Offset(if (mirror_x) x else x + w * 11f / 12f, y),
                size = Size(w / 12f, h)
            )

            // Línea horizontal
            drawRect(
                blanco,
                topLeft = Offset(x, if (mirror_y) y else y + h * 5f / 6f),
                size = Size(w, h / 6f)
            )

            drawRect(
                rojo,
                topLeft = Offset(x, if (mirror_y) y else y + h * 11f / 12f),
                size = Size(w, h / 12f)
            )
        }

        drawQuadrant(0f, 0f, false, false)
        drawQuadrant(w, 0f, true, false)
        drawQuadrant(0f, h, mirror_x = false, mirror_y = true)
        drawQuadrant(w, h, mirror_x = true, mirror_y = true)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.aspectRatio(4 / 3f))
    }
}
