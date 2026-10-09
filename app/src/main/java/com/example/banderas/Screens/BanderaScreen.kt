package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderas.R

fun drawEquitativeTriangle(base: Float, height: Float, position: Offset): Path
{
    val path = Path()

    path.lineTo(position.x - (base / 2f), position.y)
    path.lineTo(position.x + (base / 2f), position.y)
    path.lineTo(base / 2f, position.y + height)
    path.lineTo(position.x - (base / 2f), position.y)

    path.close()
    return path
}

@Composable
fun BanderaScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val black = Color.Black
    val white = Color.White
    val orange = colorResource(R.color.OrangeButhan)
    val yellow = colorResource(R.color.YellowButhan)

    Canvas(modifier = modifier)
    {
        drawRect(orange)

        val trianglePath = Path().apply {
            moveTo(0f, 0f);
            lineTo(size.width, 0f);
            lineTo(0f, size.height);
            close();
        }
        drawPath(trianglePath, yellow)
    }

    Box(modifier = modifier.fillMaxSize())
    {
        Canvas(modifier = Modifier.width(200.dp).height(24.dp).align(Alignment.Center))
        {
            val dragon = Path()

            dragon.moveTo(0f, 0f);
            repeat(12)
            { index ->
                if (index % 2 == 0) dragon.lineTo(64f * index, -16f)
                else dragon.lineTo(64f * index, 16f)
            }
            dragon.close();
            drawPath(dragon, white)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface { BanderaScreen(modifier = Modifier.aspectRatio(4 / 3f)) }
}
