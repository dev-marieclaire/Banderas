package com.example.banderas.Screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R

@Composable
fun BanderaScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val blue  = createRef()
        val white = createRef()
        val red   = createRef()

        val leftGuide   = createGuidelineFromStart(1f / 4f)
        val rightGuide  = createGuidelineFromStart(3f / 4f)

        val fill = Dimension.fillToConstraints

        // shared vertical constraints, extended per stripe horizontally
        fun ConstrainScope.fullHeight() {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            height = fill
        }

        Box(Modifier.constrainAs(blue) {
            fullHeight()
            start.linkTo(parent.start)
            end.linkTo(leftGuide)
            width = fill
        }.background(colorResource(R.color.RedSpain)))

        Box(Modifier.constrainAs(white) {
            fullHeight()
            start.linkTo(leftGuide)
            end.linkTo(rightGuide)
            width = fill
        }.background(colorResource(R.color.YellowSpain)))

        Box(Modifier.constrainAs(red) {
            fullHeight()
            start.linkTo(rightGuide)
            end.linkTo(parent.end)
            width = fill
        }.background(colorResource(R.color.RedSpain)))
    }
}

@Preview()
@Composable
fun BanderaScreenPreview()
{
    Surface {
        BanderaScreen(modifier = Modifier.fillMaxSize())
    }
}
