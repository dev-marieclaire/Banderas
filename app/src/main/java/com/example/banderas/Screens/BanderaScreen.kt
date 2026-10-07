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
    val red = R.color.RedSA
    Canvas(modifier = modifier)
    {
        drawPath(
            drawEquitativeTriangle(80f, 50f, Offset(60f, 60f)),
            color = red
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.aspectRatio(4 / 3f))
    }
}
