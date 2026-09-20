package com.example.banderas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banderas.ui.theme.BanderasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanderasTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding -> BanderaFrancia(innerPadding) }
            }
        }
    }
}

@Composable
fun BanderaFrancia(innerPadding: PaddingValues = PaddingValues.Zero, modifier: Modifier = Modifier)
{
    Row(modifier = Modifier.padding(innerPadding).fillMaxSize())
    {
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(Color(0xFF0055A4)))
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(Color.White))
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(Color(0xFFEF4135)))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BanderasTheme {
        BanderaFrancia()
    }
}
