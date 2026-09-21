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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.banderas.ui.theme.BanderasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanderasTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding -> BanderaBrasil(Modifier.padding(innerPadding)) }
            }
        }
    }
}

val RomboShape = GenericShape { size, _ ->
    moveTo(size.width / 2f, 0f)
    lineTo(size.width, size.height / 2f)
    lineTo(size.width / 2f, size.height)
    lineTo(0f, size.height / 2f)
    close()
}

@Composable
fun BanderaBrasil(modifier: Modifier = Modifier)
{
    Box(modifier = modifier.fillMaxSize().background(Color(0xFF009B3A)),
        contentAlignment = Alignment.Center)
    {
        Box(modifier = Modifier
            .fillMaxSize()
            .clip(RomboShape)
            .background(Color(0xFFFEDF00))
        )
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .size(90.dp)
                .clip(CircleShape)
                .background(Color(0xFF002776))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaBrasilPreview() {
    Surface {
        BanderaBrasil(modifier = Modifier.fillMaxSize())
    }
}
