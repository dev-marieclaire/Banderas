package com.example.banderas.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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

@Composable
fun BanderaScreen(modifier: Modifier = Modifier)
{
    ConstraintLayout(modifier = modifier)
    {
        val (c1, c2, c3) = createRefs();

        val guideline1 = createGuidelineFromTop(1/3f);
        val guideline2 = createGuidelineFromBottom(1/3f);
        Box(modifier = Modifier
            .constrainAs(c1)
            {
                top.linkTo(parent.top)
                bottom.linkTo(guideline1)

                start.linkTo(parent.start)
                end.linkTo(parent.end)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })
        {}
        ConstraintLayout(modifier = Modifier
            .constrainAs(c2)
            {
                top.linkTo(guideline1)
                bottom.linkTo(guideline2)

                start.linkTo(parent.start)
                end.linkTo(parent.end)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })
        {
            Box(modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(colorResource(R.color.GoldArg)))
        }
        Box(modifier = Modifier
            .constrainAs(c3)
            {
                top.linkTo(guideline2)
                bottom.linkTo(parent.bottom)

                start.linkTo(parent.start)
                end.linkTo(parent.end)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })
        {}
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaArgentinaPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.fillMaxSize())
    }
}
