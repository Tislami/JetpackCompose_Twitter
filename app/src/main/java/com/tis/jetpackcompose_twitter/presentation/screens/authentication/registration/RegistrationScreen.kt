package com.tis.jetpackcompose_twitter.presentation.screens.authentication.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tis.jetpackcompose_twitter.presentation.screens.authentication.*
import com.tis.jetpackcompose_twitter.presentation.screens.authentication.clipPadding


@Composable
fun RegistrationScreen() {

    var a by remember { mutableStateOf("") }
    var b by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
            .background(
                color = MaterialTheme.colors.background
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Greeting(
            modifier = Modifier.clipPadding(64.dp),
            title = "Hello \nWelcome Back"
        )


        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center
        ) {

            AuthTextField(
                value = a,
                onValueChange = { a = it },
                placeholder = "Email",
                icon = Icons.Default.Email
            )

            AuthTextField(
                value = b,
                onValueChange = { b = it },
                placeholder = "Fullname",
                icon = Icons.Default.Person
            )

            AuthTextField(
                value = b,
                onValueChange = { b = it },
                placeholder = "Password",
                icon = Icons.Default.Lock
            )


        }


        PrimaryButton(
            text = "Sign up",
            onClick = {}
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
                onClick = { }
            )
        }
    }
}