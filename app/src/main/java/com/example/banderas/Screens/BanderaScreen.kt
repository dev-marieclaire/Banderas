package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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

    ConstraintLayout(modifier = modifier)
    {
        val (ref1, ref2) = createRefs()

        ConstraintLayout(modifier = Modifier
            .constrainAs(ref1, {
                top.linkTo(parent.top)

                start.linkTo(parent.start)
                end.linkTo(parent.end)

                width = Dimension.fillToConstraints
                height = Dimension.value(96.dp)
            })
            .background(blueColor)
        ) { }

        ConstraintLayout(modifier = Modifier
            .constrainAs(ref2, {
                bottom.linkTo(parent.bottom)

                start.linkTo(parent.start)
                end.linkTo(parent.end)

                width = Dimension.fillToConstraints
                height = Dimension.value(96.dp)
            })
            .background(blueColor)
        ) { }
    }

    Canvas(modifier = modifier.fillMaxSize())
    {
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
