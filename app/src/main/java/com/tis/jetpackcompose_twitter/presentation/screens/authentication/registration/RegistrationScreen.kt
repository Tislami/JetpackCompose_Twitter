package com.tis.jetpackcompose_twitter.presentation.screens.authentication.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tis.jetpackcompose_twitter.presentation.screens.authentication.*
import com.tis.jetpackcompose_twitter.utils.onClick
import com.tis.jetpackcompose_twitter.utils.onValueChange
import kotlinx.coroutines.flow.collectLatest


@Composable
fun RegistrationScreen(
    navController: NavController,
    viewModel: AuthViewModel = hiltViewModel(),
) {

    val scaffoldState = rememberScaffoldState()
    val authState = viewModel.authState.value

    LaunchedEffect(key1 = Unit) {
        viewModel.registrationEventFlow.collectLatest { event ->
            when (event) {
                is RegistrationEvent.Error -> {
                    scaffoldState.snackbarHostState.showSnackbar(event.message)

                }
                RegistrationEvent.SignedUp -> {

                }
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState) {
        RegistrationContent(
            modifier = Modifier.padding(it),
            authState = authState,
            onEmailChange = viewModel::setEmail,
            onPasswordChange = viewModel::setPassword,
            onFullNameChange = viewModel::setFullName,
            onSignUp = viewModel::signUp,
            onSignIn = {  },
        )
    }
}


@Composable
private fun RegistrationContent(
    modifier: Modifier= Modifier,
    authState: AuthState,
    onEmailChange: onValueChange,
    onPasswordChange: onValueChange,
    onFullNameChange: onValueChange,
    onSignUp: onClick,
    onSignIn: onClick,
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

        Greeting(
            modifier = Modifier,
            title = "Hello \nWelcome Back"
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
                value = authState.fullName,
                onValueChange = onFullNameChange,
                placeholder = "Fullname",
                icon = Icons.Default.Person
            )

            AuthTextField(
                value = authState.password,
                onValueChange = onPasswordChange,
                placeholder = "Password",
                icon = Icons.Default.Lock
            )
        }

        PrimaryButton(
            text = "Sign up",
            onClick = onSignUp
        )

        Spacer(modifier = Modifier
            .fillMaxHeight()
            .weight(1f))

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                text = "Do you have an account?",
                color = MaterialTheme.colors.primary
            )

            AuthTextButton(
                text = "Sign in",
                onClick = onSignIn
            )
        }
    }
}