package com.example.banderas.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R

@Composable
fun BanderaScreen(modifier: Modifier = Modifier)
{
    ConstraintLayout(modifier = modifier) {
        val (c1, c2, c3) = createRefs();

        val guideline1 = createGuidelineFromTop(1/3f);
        val guideline2 = createGuidelineFromTop(2/3f);

        Box(modifier = Modifier.background(Color.Red).constrainAs(c1)
        {
            top.linkTo(parent.top)
            bottom.linkTo(guideline1)

            start.linkTo(parent.start)
            end.linkTo(parent.end)

            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        {
        }
        ConstraintLayout (modifier = Modifier.background(Color.White).constrainAs(c2)
        {
            top.linkTo(guideline1)
            bottom.linkTo(guideline2)

            start.linkTo(parent.start)
            end.linkTo(parent.end)

            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        {
            val (imagen, texto) = createRefs();
            Image(
                painter = painterResource(R.drawable.escudo),
                contentDescription = null,
                modifier = Modifier.constrainAs(imagen) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Text(
                "yey", fontSize = 24.sp, modifier = Modifier.constrainAs(texto){
                    top.linkTo(imagen.bottom)

                    start.linkTo(imagen.start)
                    end.linkTo(imagen.end)
                }
            )
        }
        Box(modifier = Modifier.background(colorResource(R.color.GreenMexico)).constrainAs(c3)
        {
            top.linkTo(guideline2)
            bottom.linkTo(parent.bottom)

            start.linkTo(parent.start)
            end.linkTo(parent.end)

            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        })
        {
        }
    }
}

@Preview (showBackground = true)
@Composable
fun BanderaScreenPreview()
{
    BanderaScreen(modifier = Modifier.fillMaxSize())
}