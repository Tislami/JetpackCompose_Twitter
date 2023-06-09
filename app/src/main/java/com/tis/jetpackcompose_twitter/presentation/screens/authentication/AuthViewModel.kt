package com.tis.jetpackcompose_twitter.presentation.screens.authentication

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tis.jetpackcompose_twitter.domain.model.Response
import com.tis.jetpackcompose_twitter.domain.use_case.UseCase
import com.tis.jetpackcompose_twitter.utils.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {

    var authState = mutableStateOf(AuthState())
        private set

    private var loginJob: Job? = null
    val isLoading = mutableStateOf(false)

    private val _authEventFlow = MutableSharedFlow<AuthUiEvent>()
    val authEventFlow = _authEventFlow.asSharedFlow()


    init {
        getAuthState()
    }
    fun setEmail(value: String) {
        authState.value = authState.value.copy(
            email = value
        )
    }

    fun setPassword(value: String) {
        authState.value = authState.value.copy(
            password = value
        )
    }

    fun setFullName(value: String) {
        authState.value = authState.value.copy(
            fullName = value
        )
    }

    fun signIn() {
        loginJob?.cancel()
        loginJob = viewModelScope.launch {
            useCase.authUseCase.login(authState.value.email, authState.value.password)
                .collect { response ->
                    when (response) {
                        is Response.Error -> {
                            isLoading.value = false
                            _authEventFlow.emit(AuthUiEvent.Error(response.message))
                        }
                        is Response.Loading -> {
                            isLoading.value = true
                        }
                        is Response.Success -> {
                            isLoading.value = false
                            _authEventFlow.emit(AuthUiEvent.SignedIn)
                        }
                    }
                }
        }
    }

    fun signUp() {
        viewModelScope.launch {
            useCase.authUseCase.createUser(authState.value.email, authState.value.password)
                .collect { response ->
                    when (response) {
                        is Response.Error -> {
                            isLoading.value = false
                            _authEventFlow.emit(AuthUiEvent.Error(response.message))
                        }
                        is Response.Loading -> {
                            isLoading.value = true
                        }
                        is Response.Success -> {
                            isLoading.value = false
                            _authEventFlow.emit(AuthUiEvent.SignedUp)
                        }
                    }
                }
        }
    }

    private fun getAuthState() {
        viewModelScope.launch {
            useCase.authUseCase.createUser(authState.value.email, authState.value.password)
                .collect { response ->
                    when (response) {
                        is Response.Error -> {
                            isLoading.value = false
                            _authEventFlow.emit(AuthUiEvent.Error(response.message))
                        }
                        is Response.Loading -> {
                            isLoading.value = true
                        }
                        is Response.Success -> {
                            isLoading.value = false
                            _authEventFlow.emit(AuthUiEvent.SignedUp)
                        }
                    }
                }
        }
    }
}


