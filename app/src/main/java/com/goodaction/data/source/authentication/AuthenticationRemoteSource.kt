package com.goodaction.data.source.authentication

import com.goodaction.models.AuthenticationModel

interface AuthenticationRemoteSource {

    suspend fun signUp(data: HashMap<String, String>): AuthenticationModel

    suspend fun signIn(data: HashMap<String, String>): AuthenticationModel
}