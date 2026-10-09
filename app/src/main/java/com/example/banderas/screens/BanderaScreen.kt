package com.example.banderas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.R

@Composable
fun BanderaEspana(modifier: Modifier = Modifier)
{
    Column(modifier = modifier.fillMaxSize())
    {
        Box(Modifier.weight(1f).fillMaxWidth().background(colorResource(R.color.RedSpain)))
        Box(Modifier.weight(2f).fillMaxWidth().background(colorResource(R.color.YellowSpain)))
        Box(Modifier.weight(1f).fillMaxWidth().background(colorResource(R.color.RedSpain)))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaEspanaPreview() {
    Surface {
        BanderaEspana(modifier = Modifier.fillMaxSize())
    }
}
