package com.goodaction.di.remote

import com.goodaction.data.remote.AuthenticationRemoteSourceImpl
import com.goodaction.data.source.authentication.AuthenticationRemoteSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteSourceModule {

    @Binds
    abstract fun bindAuthenticationRemoteSource(
        impl: AuthenticationRemoteSourceImpl
    ): AuthenticationRemoteSource
}