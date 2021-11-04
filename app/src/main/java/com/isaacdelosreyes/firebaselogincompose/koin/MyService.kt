package com.isaacdelosreyes.firebaselogincompose.koin

import com.google.firebase.database.FirebaseDatabase
import com.isaacdelosreyes.firebaselogincompose.ui.screens.registerscreen.RegisterRepository
import com.isaacdelosreyes.firebaselogincompose.ui.screens.registerscreen.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val registerModule = module {

    single { FirebaseDatabase.getInstance() }
    single { RegisterRepository(get()) }
    viewModel { RegisterViewModel(get()) }
}