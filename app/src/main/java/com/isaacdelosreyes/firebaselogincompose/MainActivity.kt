package com.isaacdelosreyes.firebaselogincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.isaacdelosreyes.firebaselogincompose.ui.screens.dashboard.DashboardScreen
import com.isaacdelosreyes.firebaselogincompose.ui.screens.login.LoginScreen
import com.isaacdelosreyes.firebaselogincompose.ui.screens.register.RegisterScreen

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
        startDestination = "login",
    ) {
        composable("login") {
            LoginScreen({
                navController.navigate("register")
            }, {
                navController.navigate("dashboard/$it") {
                    popUpTo("login") { inclusive = true }
                }
            })
        }
        composable("register") {
            RegisterScreen() {
                navController.navigate("login") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }
        composable(
            "dashboard/{email}",
            arguments = listOf(navArgument("email") {
                type = NavType.StringType
            })
        ) {
            val email = it.arguments?.getString("email")
            DashboardScreen(email)
        }
    }
}
