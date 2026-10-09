package com.example.banderas.screens

import android.R.attr.end
import android.R.attr.top
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester.Companion.FocusRequesterFactory.component1
import androidx.compose.ui.focus.FocusRequester.Companion.FocusRequesterFactory.component2
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.banderas.R


val RomboShape = GenericShape { size, _ ->
    moveTo(size.width / 2f, 0f)
    lineTo(size.width, size.height / 2f)
    lineTo(size.width / 2f, size.height)
    lineTo(0f, size.height / 2f)
    close()
}


@Composable
fun BanderaScreen(modifier: Modifier = Modifier)
{
    Box(modifier = modifier
        .fillMaxSize()
        .background(colorResource(R.color.GreenBrazil)),
        contentAlignment = Alignment.Center
    )
    {
        val (ref1, ref2) = createRefs()
        Box(modifier = Modifier
            .fillMaxSize()
            .clip(RomboShape)
            .background(colorResource(R.color.YellowBrazil))
        )

        Box(modifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
            .background(colorResource(R.color.BlueBrazil))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BanderaScreenPreview() {
    Surface { BanderaScreen(modifier = Modifier.fillMaxSize()) }
}
