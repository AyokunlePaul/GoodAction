package com.goodaction.presentation.authentication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.goodaction.data.source.authentication.AuthenticationRemoteSource
import com.goodaction.models.states.SignIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationActivityViewModel @Inject constructor(
    private val remoteSource: AuthenticationRemoteSource
) : ViewModel() {

    private val _signIn = MutableStateFlow<SignIn>(SignIn.Initial)
    val signIn: StateFlow<SignIn> get() = _signIn.asStateFlow()

    private val _signUp = MutableStateFlow<SignIn>(SignIn.Initial)
    val signUp: StateFlow<SignIn> get() = _signUp.asStateFlow()

    fun signInWithEmail(email: String, password: String) {
        val data = hashMapOf(
            "email" to email,
            "password" to password
        )
        signIn(data)
    }

    fun signInWithPhone(phone: String, password: String) {
        val data = hashMapOf(
            "phone" to phone,
            "password" to password
        )
        signIn(data)
    }

    private fun signIn(data: HashMap<String, String>) = viewModelScope.launch {
        val response = runCatching { remoteSource.signIn(data) }
        response.onFailure { }
        response.onSuccess { }
    }

    fun signUp(
        firstName: String,
        lastName: String,
        email: String,
        phone: String,
        password: String
    ) = viewModelScope.launch {
        val data = hashMapOf(
            "firstName" to firstName,
            "lastName" to lastName,
            "fullName" to "$firstName + $lastName",
            "email" to email,
            "phoneNumber" to phone,
            "password" to password
        )
        val response = runCatching { remoteSource.signUp(data) }
        response.onFailure { }
        response.onSuccess { }
    }
}