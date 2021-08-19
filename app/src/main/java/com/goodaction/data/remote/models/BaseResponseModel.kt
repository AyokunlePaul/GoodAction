package com.goodaction.data.remote.models

data class BaseResponseModel<T>(
    val message: String?,
    val data: T?,
    val error: String?,
    val statusCode: String?
)
