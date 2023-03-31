package com.tis.jetpackcompose_twitter.presentation.screens.authentication.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.google.common.graph.Graph
import com.tis.jetpackcompose_twitter.presentation.screens.authentication.login.LoginScreen
import com.tis.jetpackcompose_twitter.presentation.screens.authentication.registration.RegistrationScreen
import com.tis.jetpackcompose_twitter.presentation.screens.main.Screens
import javax.annotation.concurrent.Immutable


fun NavGraphBuilder.authNavigation(
    navController: NavController,
) {
    navigation(
        route =Screens.AUTHENTICATION,
        startDestination = AuthScreens.Login.route,
    ) {

        composable(route = AuthScreens.Registration.route)
        {
            RegistrationScreen(
                navController = navController
            )
        }

        composable(AuthScreens.Login.route) {
            LoginScreen(
                navController = navController
            )
        }
    }
}

sealed class AuthScreens(val route: String) {
    @Immutable
    object Registration : AuthScreens("Registration")
    @Immutable
    object Login : AuthScreens("Login")
}