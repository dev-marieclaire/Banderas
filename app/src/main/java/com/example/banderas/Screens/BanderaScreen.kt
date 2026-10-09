package com.example.banderas.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R

@Composable
fun BanderaScreen(modifier: Modifier = Modifier)
{
    ConstraintLayout(modifier = modifier.fillMaxSize())
    {
        val blue  = createRef()
        val white = createRef()
        val red   = createRef()

        val leftGuide   = createGuidelineFromStart(1f / 3f)
        val rightGuide  = createGuidelineFromStart(2f / 3f)

        Box(Modifier.constrainAs(blue)
        {
            start.linkTo(parent.start)
            end.linkTo(leftGuide)

            width = Dimension.fillToConstraints
        }.background(Color.Black).fillMaxHeight())

        Box(Modifier.constrainAs(white)
        {
            start.linkTo(leftGuide)
            end.linkTo(rightGuide)
            width = Dimension.fillToConstraints
        }.background(colorResource(R.color.RedGermany)).fillMaxHeight())

        Box(Modifier.constrainAs(red)
        {
            start.linkTo(rightGuide)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
        }.background(colorResource(R.color.YellowGermany)).fillMaxHeight())
    }
}

@Preview ()
@Composable
fun BanderaScreenPreview()
{
    Surface {
        BanderaScreen(modifier = Modifier.fillMaxSize())
    }
}
