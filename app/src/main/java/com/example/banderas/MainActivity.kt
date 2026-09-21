package com.example.banderas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.banderas.StarShape
import com.example.banderas.ui.theme.BanderasTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanderasTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding -> BanderaEEUU(Modifier.padding(innerPadding)) }
            }
        }
    }
}

val StarShape = GenericShape { size, _ ->
    val cx = size.width / 2f
    val cy = size.height / 2f
    val outerR = minOf(cx, cy)
    val innerR = outerR * 0.4f
    var angle = -PI / 2

    moveTo(cx + outerR * cos(angle).toFloat(), cy + outerR * sin(angle).toFloat())

    for (i in 1..10) {
        angle += PI / 5
        val r = if (i % 2 == 0) outerR else innerR
        lineTo(cx + r * cos(angle).toFloat(), cy + r * sin(angle).toFloat())
    }
    close()
}

@Composable
fun BanderaEEUU(modifier: Modifier = Modifier)
{
    Box(modifier = modifier.fillMaxSize())
    {
        Column(modifier = Modifier.fillMaxSize())
        {
            repeat(13)
            {   index ->
                Box(Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(if (index % 2 == 0) Color(0xFFB22234) else Color.White)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(0.4f)
//                .fillMaxHeight(0.54f)
                .background(Color(0xFF3C3B6E)),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            repeat(9)
            {   index ->
                Row(Modifier.fillMaxWidth().padding(5.dp), horizontalArrangement = Arrangement.Center)
                {
                    repeat(if (index % 2 == 0) 5 else 6)
                    {
                        Box(
                            modifier = Modifier
                                .size(25.dp)
                                .clip(StarShape)
                                .background(Color(0xFFFFFFFF))
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaEEUUPreview() {
    Surface {
        BanderaEEUU(modifier = Modifier.fillMaxSize())
    }
}
