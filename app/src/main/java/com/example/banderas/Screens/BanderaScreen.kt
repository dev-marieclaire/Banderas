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
    val gold = colorResource(R.color.GoldSA)
    val red = colorResource(R.color.RedSA)
    val green = colorResource(R.color.GreenSA)
    val blue = colorResource(R.color.BlueSA)

    Canvas(modifier = modifier)
    {
        drawRect(blue)
        drawRect(red, Offset.Zero, Size(size.width, size.height / 2f))
        drawRect(white, Offset(0f, size.height * 7 / 24f), Size(size.width, size.height * 5 / 12f))

        val triWidth1 = size.width * 0.6f;
        val trianglePath1 = Path().apply {
            moveTo(0f, 0f - size.height * 0.25f);
            lineTo(triWidth1, size.height / 2f);
            lineTo(0f, size.height * 1.25f);
            close();
        }
        drawPath(trianglePath1, white)

        val triWidth2 = size.width * 0.6f;
        val trianglePath2 = Path().apply {
            moveTo(-size.width / 3, -size.height / 2f);
            lineTo(triWidth2 - size.width / 12, size.height / 2f);
            lineTo(-size.width / 3, size.height + size.width / 3);
            close();
        }
        drawPath(trianglePath2, green)

        drawRect(green, Offset(0f, size.height * 9 / 24f), Size(size.width, size.height * 3 / 12f))

        val triWidth3 = size.width * 0.7f;
        val trianglePath3 = Path().apply {
            moveTo(0f, size.height * 1 / 8);
            lineTo(triWidth3 / 2, size.height / 2f);
            lineTo(0f, size.height * 7 / 8);
            close();
        }
        drawPath(trianglePath3, gold)

        val triWidth4 = size.width * 0.5f;
        val trianglePath4 = Path().apply {
            moveTo(0f, size.height * 3 / 12);
            lineTo(triWidth4 / 2, size.height / 2f);
            lineTo(0f, size.height * 9 / 12);
            close();
        }
        drawPath(trianglePath4, black)
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.aspectRatio(4 / 3f))
    }
}
