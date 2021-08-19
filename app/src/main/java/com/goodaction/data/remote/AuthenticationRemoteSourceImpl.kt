package com.goodaction.data.remote

import com.goodaction.data.remote.services.AuthenticationService
import com.goodaction.data.source.authentication.AuthenticationRemoteSource
import com.goodaction.models.AuthenticationModel
import javax.inject.Inject

class AuthenticationRemoteSourceImpl @Inject constructor(
    private val authenticationService: AuthenticationService
) : AuthenticationRemoteSource {

    override suspend fun signUp(data: HashMap<String, String>): AuthenticationModel {
        TODO("Not yet implemented")
    }

    override suspend fun signIn(data: HashMap<String, String>): AuthenticationModel {
        TODO("Not yet implemented")
    }
}