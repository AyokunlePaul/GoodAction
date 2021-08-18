package com.goodaction.utils.authentication

interface GoodActionAuthentication {

    suspend fun signIn(): User

    suspend fun isSignedIn(): Boolean

    data class User(
        val email: String,
        val name: String
    )
}