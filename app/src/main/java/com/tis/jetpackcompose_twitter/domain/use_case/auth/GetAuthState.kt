package com.tis.jetpackcompose_twitter.domain.use_case.auth

import com.tis.jetpackcompose_twitter.domain.repository.AuthRepository

class GetAuthState(private val repository: AuthRepository)
{
    operator fun invoke() = repository.getAuthState()
}