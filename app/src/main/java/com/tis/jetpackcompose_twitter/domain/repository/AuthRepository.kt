package com.tis.jetpackcompose_twitter.domain.repository

import com.google.firebase.auth.FirebaseAuth
import com.tis.jetpackcompose_twitter.domain.model.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

interface AuthRepository {
    fun createUser(email: String, password: String): Flow<Response<String>>
    fun login(email: String, password: String): Flow<Response<String>>
    fun getAuthState(): Flow<Response<String?>>
}

class AuthRepositoryImpl(private val auth: FirebaseAuth) : AuthRepository {

    override fun createUser(email: String, password: String) = flow {
        try {
            var result: Response<String> = Response.Loading
            emit(result)
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    result = Response.Success(it.user!!.uid)
                }.addOnFailureListener {
                    result = Response.Error(it.message?: "Unknown error")
                }.await()
            emit(result)
        } catch (e: Exception) {
            emit(Response.Error(e.message ?: "Error"))
        }
    }

    override fun login(email: String, password: String) = flow {
        try {
            var result: Response<String> = Response.Loading
            emit(result)
            auth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    result = Response.Success(it.user!!.uid) }
                .addOnFailureListener {
                    result = Response.Error(it.message?: "Unknown error") }
                .await()
            emit(result)
        } catch (e: Exception) {
            emit(Response.Error(e.message ?: "Unknown error"))
        }
    }


    override fun getAuthState() = flow {
        try {
            emit(Response.Loading)
            if (auth.currentUser!=null){
                emit(Response.Success(auth.currentUser!!.uid))
            }
            else {
                emit(Response.Success(null))
            }
        }
        catch (e:Exception){
            emit(Response.Error(e.message?:"Unknown"))
        }
    }

}