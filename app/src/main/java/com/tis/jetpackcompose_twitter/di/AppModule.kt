package com.tis.jetpackcompose_twitter.di

import com.tis.jetpackcompose_twitter.data.FirebaseDatabase
import com.tis.jetpackcompose_twitter.domain.repository.AuthRepository
import com.tis.jetpackcompose_twitter.domain.repository.AuthRepositoryImpl
import com.tis.jetpackcompose_twitter.domain.use_case.UseCase
import com.tis.jetpackcompose_twitter.domain.use_case.auth.AuthUseCase
import com.tis.jetpackcompose_twitter.domain.use_case.auth.CreateUser
import com.tis.jetpackcompose_twitter.domain.use_case.auth.GetAuthState
import com.tis.jetpackcompose_twitter.domain.use_case.auth.Login
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideFirebaseDatabase(): FirebaseDatabase = FirebaseDatabase()

    @Provides
    @Singleton
    fun provideAuthRepository(firebaseDatabase: FirebaseDatabase): AuthRepository {
        return AuthRepositoryImpl(firebaseDatabase.auth)
    }

    @Provides
    @Singleton
    fun provideAuthUseCase(authRepository: AuthRepository): AuthUseCase {
        return AuthUseCase(
            createUser = CreateUser(authRepository),
            login = Login(authRepository),
            getAuthState = GetAuthState(authRepository),
        )
    }

    @Provides
    @Singleton
    fun provideUseCase(
        authUseCase: AuthUseCase,
    ): UseCase {
        return UseCase(
            authUseCase = authUseCase
        )
    }
}