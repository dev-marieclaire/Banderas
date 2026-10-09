package com.example.banderas.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R

private fun DrawScope.triangleRight(color: Color) {
    drawPath(
        Path().apply {
            moveTo(0f, 0f)
            lineTo(size.width, size.height / 2f)
            lineTo(0f, size.height)
            close()
        },
        color
    )
}

@Composable
fun BanderaScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val black = Color.Black
    val white = Color.White
    val gold = colorResource(R.color.GoldSA)
    val red = colorResource(R.color.RedSA)
    val green = colorResource(R.color.GreenSA)
    val blue = colorResource(R.color.BlueSA)

    BoxWithConstraints(modifier = modifier)
    {
        val w = maxWidth
        val h = maxHeight

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .clipToBounds()
        )
        {
            val gHalf = createGuidelineFromTop(0.5f)
            val g7_24 = createGuidelineFromTop(7f / 24f)
            val g9_24 = createGuidelineFromTop(9f / 24f)
            val g15_24 = createGuidelineFromTop(15f / 24f)
            val g17_24 = createGuidelineFromTop(17f / 24f)

            val refs = List(8) { createRef() }

            Box(
                Modifier
                    .constrainAs(refs[0])
                    {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
                    .background(blue)
            )

            Box(
                Modifier
                    .constrainAs(refs[1])
                    {
                        top.linkTo(parent.top)
                        bottom.linkTo(gHalf)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
                    .background(red)
            )

            Box(
                Modifier
                    .constrainAs(refs[2])
                    {
                        top.linkTo(g7_24)
                        bottom.linkTo(g17_24)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)

                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
                    .background(white)
            )

            // 4) Triángulo BLANCO
            Canvas(
                modifier = Modifier
                    .constrainAs(refs[3])
                    {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)

                        start.linkTo(parent.start)
                    }
                    .width(w * 0.5f)
                    .height(h * 43f)
                    .offset(x = 0.dp, y = 0.dp)
            ) { triangleRight(white) }

            Canvas(
                modifier = Modifier
                    .constrainAs(refs[4])
                    {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)

                        start.linkTo(parent.start)
                    }
                    .width(w * 0.4f)
                    .height(h * 7 / 8)
                    .offset(x = 0.dp, y = 0.dp)
            ) { triangleRight(green) }

            Box(Modifier
                .constrainAs(refs[5])
                {
                    top.linkTo(g9_24)
                    bottom.linkTo(g15_24)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(green)
            )

            Canvas(
                modifier = Modifier
                    .constrainAs(refs[6])
                    {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .width(w * 0.35f)
                    .height(h * 0.75f)
                    .offset(x = 0.dp, y = h / 8f)
            ) { triangleRight(gold) }

            Canvas(
                modifier = Modifier
                    .constrainAs(refs[7])
                    {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .width(w * 0.25f)
                    .height(h * 0.5f)
                    .offset(x = 0.dp, y = h / 4f)
            ) { triangleRight(black) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview()
{
    Surface { BanderaScreen(modifier = Modifier.aspectRatio(4 / 3f)) }
}