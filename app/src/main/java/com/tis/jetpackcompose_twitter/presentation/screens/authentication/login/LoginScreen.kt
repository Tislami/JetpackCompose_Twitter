package com.tis.jetpackcompose_twitter.presentation.screens.authentication.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tis.jetpackcompose_twitter.presentation.screens.authentication.*

@Composable
fun LoginScreen() {

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
                onClick = {}
            )
        }


        PrimaryButton(
            text = "Sign in",
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
                text = "Don't you have an account?",
                color = MaterialTheme.colors.primary
            )

            AuthTextButton(
                text = "Sign up",
                onClick = { }
            )
        }
    }
}

