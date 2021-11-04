package com.isaacdelosreyes.firebaselogincompose.ui.screens.registerscreen

import com.google.firebase.database.FirebaseDatabase
import com.isaacdelosreyes.firebaselogincompose.database.model.User
import java.util.*

class RegisterRepository(private val databaseReference: FirebaseDatabase) {

    fun registerNewUser(
        name: String,
        surname: String,
        email: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        val user = User(name, surname, email)
        val id = UUID.randomUUID().toString()
        databaseReference.reference
            .child("users")
            .child(id)
            .setValue(user)
            .addOnSuccessListener {
                onSuccess()

            }.addOnFailureListener { exception ->
                exception.message?.let {
                    onFailure(it)
                }
            }
    }
}