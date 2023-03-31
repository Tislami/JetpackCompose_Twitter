package com.tis.jetpackcompose_twitter.presentation.screens.authentication

sealed class AuthUiEvent{
    data class Error(val message: String) : AuthUiEvent()
    object SignedIn : AuthUiEvent()
    object SignedUp : AuthUiEvent()
}