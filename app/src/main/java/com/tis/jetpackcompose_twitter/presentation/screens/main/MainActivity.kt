package com.tis.jetpackcompose_twitter.presentation.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tis.jetpackcompose_twitter.presentation.ui.theme.JetpackCompose_TwitterTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompose_TwitterTheme {
                AppNavigation()
            }
        }
    }
}
