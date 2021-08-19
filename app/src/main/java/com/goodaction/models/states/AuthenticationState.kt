package com.goodaction.models.states

sealed class SignIn {
    object Initial : SignIn()
    object Loading : SignIn()
    data class Fail(val message: String) : SignIn()
    data class Success<T>(val data: T): SignIn()
}

sealed class SignUp {
    object Initial : SignUp()
    object Loading : SignUp()
    data class Fail(val message: String) : SignUp()
    data class Success<T>(val data: T): SignUp()
}