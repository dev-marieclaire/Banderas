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
fun BanderaScreen(modifier: Modifier = Modifier)
{
    Column(modifier = modifier.fillMaxSize())
    {
        Box(Modifier.weight(2f).fillMaxWidth().background(colorResource(R.color.YellowCol)))
        Box(Modifier.weight(1f).fillMaxWidth().background(colorResource(R.color.BlueCol)))
        Box(Modifier.weight(1f).fillMaxWidth().background(colorResource(R.color.RedCol)))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.fillMaxSize())
    }
}