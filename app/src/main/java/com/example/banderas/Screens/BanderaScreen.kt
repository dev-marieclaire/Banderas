package com.example.banderas.Screens

import android.R.attr.height
import android.R.attr.width
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.banderas.R
import java.nio.file.Files.size
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

@Composable
fun BanderaScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val white = Color.White
    val red = colorResource(R.color.RedNepal)
    val blue = colorResource(R.color.BlueNepal)

    Canvas(modifier = modifier)
    {
        drawRect(white)

        val triangle_path_top = Path().apply {
            moveTo(0f, 0f);
            lineTo(size.width / 2, size.height / 2);
            lineTo(0f, size.height / 2);
            close();
        }
        drawPath(triangle_path_top, blue)

        val triangle_path_bottom = Path().apply {
            moveTo(0f, size.height / 4);
            lineTo(size.width / 2, size.height);
            lineTo(0f, size.height);
            close();
        }
        drawPath(triangle_path_bottom, blue)

        val inner_triangle_path_top = Path().apply {
            moveTo(20f, 40f);
            lineTo(size.width / 2 - 60, size.height / 2 - 20);
            lineTo(20f, size.height / 2 - 20);
            close();
        }
        drawPath(inner_triangle_path_top, red)

        val inner_triangle_path_bottom = Path().apply {
            moveTo(20f, size.height / 4 + 40);
            lineTo(size.width / 2 - 60, size.height - 20);
            lineTo(20f, size.height - 20);
            close();
        }
        drawPath(inner_triangle_path_bottom, red)
    }

    ConstraintLayout(modifier = modifier)
    {
        val (ref1, ref2) = createRefs();
        ConstraintLayout(modifier = Modifier
            .clip(CircleShape)
            .size(60.dp)
            .background(white)
            .constrainAs(ref1)
            {
                top.linkTo(parent.top, 60.dp)
                start.linkTo(parent.start, 20.dp)
            }
        ) { }
    }

    ConstraintLayout(modifier = modifier)
    {
        val (ref1, ref2) = createRefs();
        ConstraintLayout(modifier = Modifier
            .clip(CircleShape)
            .size(60.dp)
            .background(white)
            .constrainAs(ref1)
            {
                bottom.linkTo(parent.bottom, 40.dp)
                start.linkTo(parent.start, 20.dp)
            }
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.aspectRatio(4 / 3f))
    }
}
