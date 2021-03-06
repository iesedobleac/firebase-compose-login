package com.isaacdelosreyes.firebaselogincompose

import android.app.Application
import com.isaacdelosreyes.firebaselogincompose.koin.appModule
import com.isaacdelosreyes.firebaselogincompose.koin.loginModule
import com.isaacdelosreyes.firebaselogincompose.koin.registerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    registerModule,
                    appModule,
                    loginModule
                )
            )
        }
    }
}