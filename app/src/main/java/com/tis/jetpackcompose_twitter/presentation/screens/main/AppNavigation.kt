package com.tis.jetpackcompose_twitter.presentation.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tis.jetpackcompose_twitter.presentation.screens.authentication.navigation.authNavigation

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    Scaffold(
        content = { innerPadding ->
            NavHostController(
                modifier = Modifier
                    .padding(innerPadding),
                navController = navController
            )
        }
    )
}

@Composable
private fun NavHostController(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.AUTHENTICATION,
    ) {
        authNavigation(navController = navController)
    }
}

object Screens {
    const val AUTHENTICATION = "AUTH"
    const val PROFILE = "PROFILE"
    const val NEW_POST = "NEWPOST"
}
