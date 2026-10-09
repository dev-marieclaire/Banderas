package com.example.banderas.Screens

import android.graphics.Point
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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

    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val flag = createRef()

        Canvas(
            modifier = Modifier
                .background(blanco)
                .constrainAs(flag) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width  = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
        ) {
            val w = size.width
            val h = size.height
            val origin = Offset(0f, h)
            val radius = hypot(w, h) * 2f

            val colors = listOf(azul, amarillo, rojo, blanco, verde)
            val angles = listOf(90f, 72f, 54f, 36f, 18f, 0f)
            val d2r = PI.toFloat() / 180f

            clipRect {
                colors.forEachIndexed { i, color ->
                    val a1 = angles[i]     * d2r
                    val a2 = angles[i + 1] * d2r

                    val p1 = Offset(origin.x + radius * cos(a1), origin.y - radius * sin(a1))
                    val p2 = Offset(origin.x + radius * cos(a2), origin.y - radius * sin(a2))

                    drawPath(
                        Path().apply {
                            moveTo(origin.x, origin.y)
                            lineTo(p1.x, p1.y)
                            lineTo(p2.x, p2.y)
                            close()
                        },
                        color
                    )
                }
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
