package com.isaacdelosreyes.firebaselogincompose.ui.screens.login

import androidx.lifecycle.ViewModel

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    fun loginWithEmailAndPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        loginRepository.loginWithEmailAndPassword(
            email,
            password,
            onSuccess = {
                onSuccess()
            }, onFailure = {
                onFailure(it)
            })
    }
}