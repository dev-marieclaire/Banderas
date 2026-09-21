package com.example.banderas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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
                { innerPadding -> BanderaMexico(Modifier.padding(innerPadding)) }
            }
        }
    }
}

@Composable
fun BanderaMexico(modifier: Modifier = Modifier)
{
    Row(modifier = Modifier.fillMaxSize())
    {
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(Color(0xFF006341)))

        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(Color.White)
            , contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.escudo),
                contentDescription = "Escudo Nacional",
                modifier = Modifier.size(60.dp)
            )
        }

        Box(modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(Color.Red))
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaMexicoPreview() {
    Surface {
        BanderaMexico(Modifier.fillMaxSize())
    }
}
