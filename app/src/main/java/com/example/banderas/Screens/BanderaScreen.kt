package com.example.banderas.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    val rojo = colorResource(R.color.RedUS)
    val azul = colorResource(R.color.BlueUS)

    ConstraintLayout(modifier = modifier.fillMaxSize())
    {
        val stripes = List(13) { createRef() }
        val canton  = createRef()

        stripes.forEachIndexed { i, ref ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(if (i % 2 == 0) rojo else Color.White)
                    .constrainAs(ref)
                    {
                        top.linkTo(if (i == 0) parent.top else stripes[i - 1].bottom)
                        bottom.linkTo(if (i == 12) parent.bottom else stripes[i + 1].top)
                        height = Dimension.fillToConstraints
                    }
            )
        }

        Column(
            modifier = Modifier
                .background(azul)
                .constrainAs(canton)
                {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(stripes[6].bottom)
                    width  = Dimension.percent(0.4f)
                    height = Dimension.fillToConstraints
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        )
        {
            repeat(9)
            { row ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                )
                {
                    repeat(if (row % 2 == 0) 6 else 5)
                    {
                        Box(
                            modifier = Modifier
                                .size(25.dp)
                                .clip(StarShape)
                                .background(Color.White)
                        )
                    }
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
