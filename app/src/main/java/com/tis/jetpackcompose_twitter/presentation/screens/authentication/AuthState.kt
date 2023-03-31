package com.tis.jetpackcompose_twitter.presentation.screens.authentication

data class AuthState(
    val email: String = "",
    val password: String = "",
    val fullName: String = "",
    val isLoading: Boolean = false,
    val errorMessage: Boolean = false,
)
