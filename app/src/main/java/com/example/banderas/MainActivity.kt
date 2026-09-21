package com.example.banderas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.banderas.ui.theme.BanderasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanderasTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding -> BanderaAlemania(Modifier.padding(innerPadding)) }
            }
        }
    }
}

@Composable
fun BanderaAlemania(modifier: Modifier = Modifier)
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
            .background(Color(0xFFDD0000)))
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(Color(0xFFFFCE00)))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaAlemaniaPreview() {
    Surface {
        BanderaAlemania(modifier = Modifier.fillMaxSize())
    }
}
