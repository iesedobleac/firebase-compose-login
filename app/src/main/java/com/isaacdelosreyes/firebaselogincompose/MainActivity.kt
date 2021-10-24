package com.isaacdelosreyes.firebaselogincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.isaacdelosreyes.firebaselogincompose.ui.screens.LoginScreen
import com.isaacdelosreyes.firebaselogincompose.ui.screens.RegisterScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginParentView()
        }
    }
}

@Composable
fun LoginParentView() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen() {
                navController.navigate("register")
            }
        }
        composable("register") {
            RegisterScreen() {
                navController.navigate("login") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }
    }
}
