package com.example.banderas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
fun BanderaAlemaniaCL(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val blue  = createRef()
        val white = createRef()
        val red   = createRef()

        val topGuide   = createGuidelineFromTop(1f / 3f)
        val bottomGuide  = createGuidelineFromTop(2f / 3f)

        val fill = Dimension.fillToConstraints

        fun ConstrainScope.fullHeight() {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            height = fill
        }

        Box(Modifier.constrainAs(blue) {
            fullHeight()
            top.linkTo(parent.top)
            bottom.linkTo(topGuide)
            width = fill
        }.background(Color.Black))

        Box(Modifier.constrainAs(white) {
            fullHeight()
            top.linkTo(topGuide)
            bottom.linkTo(bottomGuide)
            width = fill
        }.background(colorResource(R.color.RedGermany)))

        Box(Modifier.constrainAs(red) {
            fullHeight()
            top.linkTo(bottomGuide)
            bottom.linkTo(parent.bottom)
            width = fill
        }.background(colorResource(R.color.YellowGermany)))
    }
}

@Preview ()
@Composable
fun BanderaAlemaniaCLPreview()
{
    Surface {
        BanderaFranciaCL(modifier = Modifier.fillMaxSize())
    }
}
