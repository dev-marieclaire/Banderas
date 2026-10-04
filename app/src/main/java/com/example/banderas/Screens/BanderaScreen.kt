package com.example.banderas.Screens

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
import androidx.compose.ui.tooling.preview.Preview
import kotlin.io.path.Path
import kotlin.math.cos
import kotlin.math.sin

fun trianglePath(cx: Float, cy: Float, r: Float, rotationDeg: Float): Path
{
    val path = Path();

    for (i in 0..2)
    {
        val angle = Math.toRadians((rotationDeg + i * 120).toDouble())
        val x = cx + r * cos(angle).toFloat();
        val y = cy + r * sin(angle).toFloat();
        if (i == 0) path.moveTo(x, y) else path.lineTo(x, y)
    }
    path.close();
    return path
}

@Composable
fun BanderaScreen(modifier: Modifier = Modifier)
{
    val blueColor = Color.Blue;
    Canvas(modifier = modifier.fillMaxSize())
    {
        drawRect(color = blueColor, size = Size(size.width, size.height / 8f));

        drawRect(
            color = blueColor,
            size = Size(size.width, size.height / 8f),
            topLeft = Offset(0f, size.height - (size.height / 8f))
        );

        drawPath(
            trianglePath(size.width / 2f, size.height / 2f,
                360f,
                90f),
            color = blueColor,
            style = Stroke(width = 80f)
        )

        drawPath(
            trianglePath(size.width / 2f, size.height / 2f,
                360f,
                -90f),
            color = blueColor,
            style = Stroke(width = 80f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.fillMaxSize())
    }
}
