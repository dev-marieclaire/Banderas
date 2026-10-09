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
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R
import kotlin.io.path.Path
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    val azul     = Color(0xFF002F6C)
    val amarillo = Color(0xFFFED141)
    val rojo     = Color(0xFFD92323)
    val blanco   = Color.White
    val verde    = Color(0xFF007A33)

    Canvas(modifier = modifier.fillMaxSize()) {
        val W = size.width
        val H = size.height
        val origin = Offset(0f, H)
        val radius = hypot(W, H) * 2f

        val colors = listOf(azul, amarillo, rojo, blanco, verde)
        val angles = listOf(90f, 72f, 54f, 36f, 18f, 0f)

        clipRect {
            colors.forEachIndexed{ i, color ->
                val a1 = angles[i]     * PI.toFloat() / 180f
                val a2 = angles[i + 1] * PI.toFloat() / 180f

                val p1 = Offset(origin.x + radius * cos(a1), origin.y - radius * sin(a1))
                val p2 = Offset(origin.x + radius * cos(a2), origin.y - radius * sin(a2))

                val path = Path().apply {
                    moveTo(origin.x, origin.y)
                    lineTo(p1.x, p1.y)
                    lineTo(p2.x, p2.y)
                    close()
                }
                drawPath(path, color)
            }
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
