package com.example.banderas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
                { innerPadding -> BanderaEspana(Modifier.padding(innerPadding)) }
            }
        }
    }
}

@Composable
fun BanderaEspana(modifier: Modifier = Modifier)
{
    Column(modifier = modifier.fillMaxSize())
    {
        Box(Modifier.weight(1f).fillMaxWidth().background(Color(0xFFAA151B)))
        Box(Modifier.weight(2f).fillMaxWidth().background(Color(0xFFF1BF00)))
        Box(Modifier.weight(1f).fillMaxWidth().background(Color(0xFFAA151B)))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaEspanaPreview() {
    Surface {
        BanderaEspana(modifier = Modifier.fillMaxSize())
    }
}
