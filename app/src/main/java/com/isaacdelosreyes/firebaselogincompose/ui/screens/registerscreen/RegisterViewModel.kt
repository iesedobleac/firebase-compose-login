package com.isaacdelosreyes.firebaselogincompose.ui.screens.registerscreen

import androidx.lifecycle.ViewModel

class RegisterViewModel(private val registerRepository: RegisterRepository) : ViewModel() {

    fun registerNewUser(
        name: String,
        surname: String,
        email: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        registerRepository.registerNewUser(name, surname, email, {
            onSuccess()
        }, {
            onFailure(it)
        })
    }
}