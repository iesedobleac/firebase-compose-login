package com.isaacdelosreyes.firebaselogincompose.koin

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.isaacdelosreyes.firebaselogincompose.ui.screens.login.LoginRepository
import com.isaacdelosreyes.firebaselogincompose.ui.screens.login.LoginViewModel
import com.isaacdelosreyes.firebaselogincompose.ui.screens.register.RegisterRepository
import com.isaacdelosreyes.firebaselogincompose.ui.screens.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { FirebaseAuth.getInstance() }
}

val registerModule = module {

    single { FirebaseDatabase.getInstance() }
    single { RegisterRepository(get(), get()) }
    viewModel { RegisterViewModel(get()) }
}

val loginModule = module {

    single { LoginRepository(get()) }
    viewModel { LoginViewModel(get()) }
}