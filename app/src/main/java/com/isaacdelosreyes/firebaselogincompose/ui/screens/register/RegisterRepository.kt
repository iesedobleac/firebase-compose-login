package com.isaacdelosreyes.firebaselogincompose.ui.screens.register

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.isaacdelosreyes.firebaselogincompose.database.model.User

class RegisterRepository(
    private val databaseReference: FirebaseDatabase,
    private val firebaseAuth: FirebaseAuth
) {

    fun registerNewUser(
        name: String,
        surname: String,
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        val user = User(name, surname, email)
        firebaseAuth.createUserWithEmailAndPassword(
            email,
            password
        ).addOnSuccessListener {
            val id = it.user?.uid
            databaseReference.reference
                .child("users")
                .child(id ?: "")
                .setValue(user)
                .addOnSuccessListener {
                    onSuccess()

                }.addOnFailureListener { exception ->
                    exception.message?.let {
                        onFailure(it)
                    }
                }

        }.addOnFailureListener { exception ->
            exception.message?.let {
                onFailure(it)
            }
        }
    }
}