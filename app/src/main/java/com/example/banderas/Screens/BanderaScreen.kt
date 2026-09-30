package com.example.banderas.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import kotlin.math.round

@Composable
fun BanderaScreen(modifier: Modifier = Modifier)
{
    ConstraintLayout(modifier = modifier)
    {
        val (ref, color) = createRefs();

        ConstraintLayout(modifier = Modifier.background(Color.White)
            .constrainAs(ref)
            {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)

                start.linkTo(parent.start)
                end.linkTo(parent.end)

                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
        )
        {
            Box(modifier = Modifier.clip(CircleShape).size(128.dp).background(Color.Red)
                .constrainAs(color)
                {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })
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
