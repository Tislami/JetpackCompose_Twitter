package com.tis.jetpackcompose_twitter.domain.use_case.auth

data class AuthUseCase (
    val createUser: CreateUser,
    val getAuthState: GetAuthState,
    val login: Login,
)