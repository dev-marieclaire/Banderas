package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R
import kotlin.math.PI
import kotlin.math.cos
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
fun BanderaScreen(modifier: Modifier = Modifier)
{
    val redTurkey = colorResource(R.color.RedTurkey);
    val white = Color.White

    ConstraintLayout(modifier = Modifier
        .background(redTurkey)
        .fillMaxSize()
    )
    {
        val (ref1, ref2) = createRefs()
        ConstraintLayout(modifier = Modifier
            .constrainAs(ref1,
                {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                    start.linkTo(parent.start, 100.dp)
                })
            .size(360.dp)
            .clip(CircleShape)
            .background(white)
        ) {}

        ConstraintLayout(modifier = Modifier
            .constrainAs(ref2,
                {
                    top.linkTo(ref1.top)
                    bottom.linkTo(ref1.bottom)

                    end.linkTo(ref1.end)
                })
            .size(256.dp)
            .clip(CircleShape)
            .background(redTurkey)
        ) {}
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    BanderaScreen(modifier = Modifier.aspectRatio(3 / 4f))
}
