package com.example.banderas.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
    ConstraintLayout(modifier = modifier)
    {
        val (c1, c2, c3, star) = createRefs();

        val vmiddle = createGuidelineFromTop(0.5f);
        val quarter = createGuidelineFromStart(1/3f);

        ConstraintLayout (modifier = Modifier
            .background(colorResource(R.color.BlueChile))
            .constrainAs(c1)
            {
                top.linkTo(parent.top)
                bottom.linkTo(vmiddle)

                start.linkTo(parent.start)
                end.linkTo(quarter)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })
        {
            ConstraintLayout (modifier = Modifier
                .clip(StarShape)
                .size(96.dp)
                .background(Color.White)
                .constrainAs(star)
                {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            {}
        }
        Box(modifier = Modifier
            .background(Color.White)
            .constrainAs(c2)
            {
                top.linkTo(parent.top)
                bottom.linkTo(vmiddle)

                start.linkTo(c1.end)
                end.linkTo(parent.end)
            }) {}
        Box(modifier = Modifier
            .background(colorResource(R.color.RedChile))
            .constrainAs(c3)
            {
                top.linkTo(vmiddle)
                bottom.linkTo(parent.bottom)

                start.linkTo(parent.start)
                end.linkTo(parent.end)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        ) {}
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.fillMaxSize())
    }
}
