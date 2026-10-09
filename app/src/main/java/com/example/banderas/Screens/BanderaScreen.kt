package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Collections.rotate
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

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

    Box(modifier = modifier.fillMaxSize().background(rojo))
    {
        Canvas(modifier = modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val path = Path().apply {
                moveTo(0f, 0f)
                lineTo(w, h)
                lineTo(0f, h)
                close()
            }
            drawPath(path, negro)
        }

        Box(modifier = modifier.fillMaxSize())
        {
            Box(modifier = Modifier
                .offset(60.dp, 90.dp)
                .size(50.dp)
                .clip(StarShape)
                .background(blanco)
            )
        }

        Box(modifier = modifier.fillMaxSize())
        {
            Box(modifier = Modifier
                .offset(20.dp, 144.dp)
                .size(50.dp)
                .clip(StarShape)
                .background(blanco)
            )
        }

        Box(modifier = modifier.fillMaxSize())
        {
            Box(modifier = Modifier
                .offset(100.dp, 144.dp)
                .size(50.dp)
                .clip(StarShape)
                .background(blanco)
            )
        }

        Box(modifier = modifier.fillMaxSize())
        {
            Box(modifier = Modifier
                .offset(60.dp, 220.dp)
                .size(50.dp)
                .clip(StarShape)
                .background(blanco)
            )
        }

        Box(modifier = modifier.fillMaxSize())
        {
            Box(modifier = Modifier
                .offset(90.dp, 192.dp)
                .size(25.dp)
                .clip(StarShape)
                .background(blanco)
            )
        }

        Box(modifier = modifier.fillMaxSize())
        {
            Box(modifier = Modifier
                .offset(256.dp, 40.dp)
                .size(96.dp)
                .clip(StarShape)
                .background(amarillo)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.aspectRatio(4 / 3f))
    }
}
