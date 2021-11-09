package com.isaacdelosreyes.firebaselogincompose.ui.screens.login

import com.google.firebase.auth.FirebaseAuth

class LoginRepository(private val firebaseAuth: FirebaseAuth) {

    fun loginWithEmailAndPassword(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                onSuccess()
            }.addOnFailureListener { exception ->
                exception.message?.let { messageNotNull ->
                    onFailure(messageNotNull)
                }
            }
    }
}