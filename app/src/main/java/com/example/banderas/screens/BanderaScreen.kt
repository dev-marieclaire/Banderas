package com.example.banderas.screens

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


@Composable
fun BanderaJapon(modifier: Modifier = Modifier)
{
    Box(modifier = modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center)
    {
        Box(modifier = Modifier
            .size(128.dp)
            .clip(CircleShape)
            .background(Color.Red)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaJaponPreview() {
    Surface {
        BanderaJapon(modifier = Modifier.fillMaxSize())
    }
}
