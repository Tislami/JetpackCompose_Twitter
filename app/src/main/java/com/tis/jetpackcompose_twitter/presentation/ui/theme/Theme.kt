package com.tis.jetpackcompose_twitter.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Blue,
    onPrimary = White,
    onSecondary = DarkGray,
    background = Black
)

private val LightColorPalette = lightColors(
    primary = Blue,
    onPrimary = White,
    onSecondary = LightGray,
    background = White
)

@Composable
fun JetpackCompose_TwitterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) { DarkColorPalette }
    else { LightColorPalette }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}