package com.tis.jetpackcompose_twitter.presentation.screens.authentication

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.tis.jetpackcompose_twitter.utils.drawIndicatorLine
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

@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
    icon: ImageVector? = null
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
            .drawIndicatorLine(BorderStroke(1.dp, Color.Black))
            .height(64.dp),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (icon != null) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onSecondary,
                    )
                }
                Box{
                    if (placeholder != null && value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = MaterialTheme.typography.button,
                            color = MaterialTheme.colors.onSecondary
                        )
                    }
                    innerTextField()
                }
            }
        }
    )
}


