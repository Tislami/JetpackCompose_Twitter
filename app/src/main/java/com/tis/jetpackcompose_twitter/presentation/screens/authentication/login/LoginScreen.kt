package com.tis.jetpackcompose_twitter.presentation.screens.authentication.login

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tis.jetpackcompose_twitter.presentation.screens.authentication.*
import com.tis.jetpackcompose_twitter.presentation.screens.authentication.navigation.AuthScreens
import com.tis.jetpackcompose_twitter.utils.onClick
import com.tis.jetpackcompose_twitter.utils.onValueChange
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel(),
) {

    val scaffoldState = rememberScaffoldState()
    val authState = viewModel.authState.value

    LaunchedEffect(key1 = Unit) {
        viewModel.loginEventFlow.collectLatest { event ->
            when (event) {
                is LoginEvent.Error -> {
                    scaffoldState.snackbarHostState.showSnackbar(event.message)
                }
                LoginEvent.SignedIn -> {

                }
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState) {


        LoginContent(
            modifier = Modifier.padding(it),
            authState = authState,
            onEmailChange = viewModel::setEmail,
            onPasswordChange = viewModel::setPassword,
            onSignIn = viewModel::signIn,
            onForgotPassword = { },
            onSignUp = { navController.navigate(AuthScreens.Registration.route) }
        )
    }
}

@Composable
private fun LoginContent(
    modifier: Modifier = Modifier,
    authState: AuthState,
    onEmailChange: onValueChange,
    onPasswordChange: onValueChange,
    onSignIn: onClick,
    onForgotPassword: onClick,
    onSignUp: onClick,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
            .background(
                color = MaterialTheme.colors.background
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Hello \nWelcome Back",
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center
        ) {
            AuthTextField(
                value = authState.email,
                onValueChange = onEmailChange,
                placeholder = "Email",
                icon = Icons.Default.Email
            )

            AuthTextField(
                value = authState.password,
                onValueChange = onPasswordChange,
                placeholder = "Password",
                icon = Icons.Default.Lock
            )
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            AuthTextButton(
                text = "Forgot Password?",
                onClick = onForgotPassword
            )
        }


        PrimaryButton(
            text = "Sign in",
            onClick = onSignIn
        )

        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        )

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = "Don't you have an account?",
                color = MaterialTheme.colors.primary
            )

            AuthTextButton(
                text = "Sign up",
                onClick = onSignUp
            )
        }
    }
}

