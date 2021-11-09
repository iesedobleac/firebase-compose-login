package com.isaacdelosreyes.firebaselogincompose.ui.screens.register

import androidx.lifecycle.ViewModel

class RegisterViewModel(private val registerRepository: RegisterRepository) : ViewModel() {

    fun registerNewUser(
        name: String,
        surname: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        registerRepository.registerNewUser(name, surname, email, password, {
            onSuccess()
        }, {
            onFailure(it)
        })
    }
}