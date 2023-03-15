package com.tis.jetpackcompose_twitter.domain.use_case.auth

import com.tis.jetpackcompose_twitter.domain.repository.AuthRepository

class CreateUser(private val repository: AuthRepository) {
    operator fun invoke(email: String , password: String) =
        repository.createUser(email = email, password=password)
}