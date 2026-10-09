package com.example.banderas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

@Composable
fun BanderaScreen(modifier: Modifier = Modifier)
{
    Row(modifier = Modifier.fillMaxSize())
    {
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(Color.Black))
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(colorResource(R.color.RedGermany)))
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(colorResource(R.color.YellowGermany)))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.fillMaxSize())
    }
}