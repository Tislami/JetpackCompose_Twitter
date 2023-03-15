package com.tis.jetpackcompose_twitter.domain.use_case

import com.tis.jetpackcompose_twitter.domain.use_case.auth.AuthUseCase

data class UseCase(
    var authUseCase: AuthUseCase
    )

