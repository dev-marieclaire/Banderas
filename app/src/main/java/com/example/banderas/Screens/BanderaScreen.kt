package com.example.banderas.Screens

import android.R.attr.height
import android.R.attr.width
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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
import androidx.constraintlayout.compose.Dimension
import com.example.banderas.R
import java.nio.file.Files.size
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.sin

@Composable
fun BanderaScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    val rojo     = colorResource(R.color.RedUK)
    val blanco   = Color.White
    val azul = colorResource(R.color.BlueUK)

    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val w = maxWidth.value
        val h = maxHeight.value
        val diagonal = hypot(w, h).dp
        val angle = -(atan2(h, w) * 180.0 / PI).toFloat()

        ConstraintLayout(modifier = modifier.fillMaxSize().background(azul))
        {
            val vertical_guideline = createGuidelineFromStart(0.5f);
            val horitonzal_guideline = createGuidelineFromTop(0.5f);

            val items = remember { List(9) { "Item $it" } }
            val refs = items.map { createRef() }

            Box(
                modifier = Modifier
                .width(80.dp)
                .background(blanco)
                .constrainAs(refs[0], {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                    start.linkTo(vertical_guideline, (-40).dp)
                    height = Dimension.fillToConstraints
                }
            )) {}

            Box(modifier = Modifier
                .rotate(angle)
                .background(blanco)
                .constrainAs(refs[4], {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    width  = Dimension.value(diagonal)
                    height = Dimension.value(80.dp)
                })
            ) {}

            Box(modifier = Modifier
                .rotate(angle)
                .background(rojo)
                .constrainAs(refs[5], {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    width  = Dimension.value(diagonal)
                    height = Dimension.value(40.dp)
                })
            ) {}

            Box(modifier = Modifier
                .rotate(-angle)
                .background(blanco)
                .constrainAs(refs[6], {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    width  = Dimension.value(diagonal)
                    height = Dimension.value(80.dp)
                })
            ) {}

            Box(modifier = Modifier
                .rotate(-angle)
                .background(rojo)
                .constrainAs(refs[7], {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    width  = Dimension.value(diagonal)
                    height = Dimension.value(40.dp)
                })
            ) {}

            Box(
                modifier = Modifier
                .width(40.dp)
                .background(rojo)
                .constrainAs(refs[1], {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                    start.linkTo(vertical_guideline, (-20).dp)
                    height = Dimension.fillToConstraints
                }
            )) {}

            Box(
                modifier = Modifier
                .height(80.dp)
                .background(blanco)
                .constrainAs(refs[2], {
                    top.linkTo(horitonzal_guideline, (-40).dp)

                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    width = Dimension.fillToConstraints
                }
            )) {}

            Box(
                modifier = Modifier
                .height(40.dp)
                .background(rojo)
                .constrainAs(refs[3], {
                    top.linkTo(horitonzal_guideline, (-20).dp)

                    start.linkTo(parent.start)
                    end.linkTo(parent.end)

                    width = Dimension.fillToConstraints
                }
            )) {}
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface {
        BanderaScreen(modifier = Modifier.aspectRatio(4 / 3f))
    }
}
