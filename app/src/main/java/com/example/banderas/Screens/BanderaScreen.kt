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
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R
import kotlin.io.path.Path
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    val azul    = Color(0xFF002F6C)
    val amarillo= Color(0xFFFED141)
    val rojo    = Color(0xFFD92323)
    val blanco  = Color.White
    val verde   = Color(0xFF007A33)

    Canvas(modifier = modifier.fillMaxSize()) {
        val W = size.width
        val H = size.height
        val origin = Offset(0f, H)

        val colors = listOf(azul, amarillo, rojo, blanco, verde)
        val angles = listOf(90f, 72f, 54f, 36f, 18f, 0f)  // 5 franjas = 6 bordes

        // Punto donde el rayo desde `origin` a `angleDeg` corta el borde
        // superior (y = 0) o derecho (x = W) del canvas.
        fun hitPoint(angleDeg: Float): Offset {
            val rad = angleDeg * (PI / 180.0)
            val dx = cos(rad).toFloat()
            val dy = -sin(rad).toFloat()   // negativo: y crece hacia abajo

            // t para alcanzar y = 0 (borde superior)
            val tTop   = if (dy < 0f) (0f - origin.y) / dy else Float.POSITIVE_INFINITY
            // t para alcanzar x = W (borde derecho)
            val tRight = if (dx > 0f) (W - origin.x) / dx else Float.POSITIVE_INFINITY

            val t = minOf(tTop, tRight)
            return Offset(origin.x + t * dx, origin.y + t * dy)
        }

        val hits = angles.map { hitPoint(it) }

        for (i in colors.indices) {
            val A = hits[i]
            val B = hits[i + 1]

            val path = Path().apply {
                moveTo(origin.x, origin.y)
                lineTo(A.x, A.y)

                // Si A está en el borde superior y B en el derecho,
                // hay que pasar por la esquina superior derecha.
                val aOnTop   = A.y <= 0.001f
                val bOnRight = B.x >= W - 0.001f
                if (aOnTop && bOnRight) {
                    lineTo(W, 0f)
                }

                lineTo(B.x, B.y)
                close()
            }
            drawPath(path, colors[i])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.fillMaxSize())
    }
}
