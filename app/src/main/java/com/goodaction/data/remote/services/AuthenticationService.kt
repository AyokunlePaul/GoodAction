package com.goodaction.data.remote.services

import com.goodaction.data.remote.models.BaseResponseModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthenticationService {

    @POST("auth/sign-up")
    suspend fun signUp(@Body data: HashMap<String, String>): BaseResponseModel<String>

    @POST("auth/sign-in")
    suspend fun signIn(@Body data: HashMap<String, String>): BaseResponseModel<String>

    @POST("auth/init-email-verification")
    suspend fun initVerificationEmail(@Body data: HashMap<String, String>): BaseResponseModel<String>

    @POST("auth/init-phone-number-verification")
    suspend fun initPhoneNumberVerification(@Body data: HashMap<String, String>): BaseResponseModel<String>

    @GET("auth/verify-email/{token}")
    suspend fun verifyEmail(@Path("token") token: String): BaseResponseModel<String>

    @POST("auth/verify-phone-number")
    suspend fun verifyPhoneNumber(@Body data: HashMap<String, String>): BaseResponseModel<String>

    @POST("auth/forgot-password")
    suspend fun forgotPassword(@Body data: HashMap<String, String>): BaseResponseModel<String>

    @GET("auth/reset-password/{token}")
    suspend fun resetPassword(@Path("token") token: String)

    @POST("auth/change-password")
    suspend fun changePassword(@Body data: HashMap<String, String>)

    @POST("auth/change-password/{token}")
    suspend fun verifyChangePasswordToken(
        @Body data: HashMap<String, String>,
        @Path("token") token: String
    )
}