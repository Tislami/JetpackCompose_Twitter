package com.tis.jetpackcompose_twitter.presentation.screens.authentication

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.tis.jetpackcompose_twitter.utils.TAG
import com.tis.jetpackcompose_twitter.utils.onClick


@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    title: String
) {
    Surface(
        shape = RoundedCornerShape(bottomEnd = 80.dp),
        color = MaterialTheme.colors.primary,
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h3,
            modifier = Modifier.padding(16.dp)

        )
    }
}


@Composable
fun PrimaryButton(
    text: String,
    onClick: onClick
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        shape = RoundedCornerShape(40)
    ) {
        Text(text = text)
    }
}

@Composable
fun AuthTextButton(
    text: String,
    onClick: onClick,
) {
    TextButton(
        onClick = onClick,
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
        )
    }
}


internal fun Modifier.clipPadding(padding: Dp): Modifier {
    return layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val paddingWidth = placeable.width - constraints.maxWidth
        val width = constraints.maxWidth
        val height = placeable.height
        layout(width, height) {
            val contentPlaceable = measurable.measure(
                Constraints(maxWidth = width - paddingWidth + padding.roundToPx(), maxHeight = height)
            )
            contentPlaceable.placeRelative((-(padding/2).roundToPx()), 0)
        }
    }
}
