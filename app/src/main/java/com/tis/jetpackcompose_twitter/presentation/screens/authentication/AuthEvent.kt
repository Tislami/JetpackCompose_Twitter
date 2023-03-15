package com.tis.jetpackcompose_twitter.presentation.screens.authentication


sealed class LoginEvent {
    data class Error(val message: String) : LoginEvent()
    object SignedIn : LoginEvent()
}

sealed class RegistrationEvent{
    data class Error(val message: String) : RegistrationEvent()
    object SignedUp : RegistrationEvent()
}