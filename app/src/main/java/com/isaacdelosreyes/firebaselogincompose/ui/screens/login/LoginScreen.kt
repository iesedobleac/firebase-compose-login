package com.isaacdelosreyes.firebaselogincompose.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.isaacdelosreyes.firebaselogincompose.components.CustomSnackBar
import com.isaacdelosreyes.firebaselogincompose.components.LoginButton
import com.isaacdelosreyes.firebaselogincompose.components.LoginInput
import com.isaacdelosreyes.firebaselogincompose.ui.theme.Green
import com.isaacdelosreyes.firebaselogincompose.ui.theme.Violet
import com.isaacdelosreyes.firebaselogincompose.ui.theme.White900
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(goToRegisterScreen: () -> Unit, goToDashboardScreen: (String) -> Unit) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val viewModel = getViewModel<LoginViewModel>()

    val scope = rememberCoroutineScope()
    val snackBarHostState = SnackbarHostState()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = com.isaacdelosreyes.firebaselogincompose.R.drawable.login_background),
                contentDescription = "Background del login",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            ConstraintLayout() {

                val surface = createRef()

                Surface(
                    Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                        .clip(RoundedCornerShape(topStartPercent = 8, topEndPercent = 8))
                        .constrainAs(surface) {
                            bottom.linkTo(parent.bottom)
                        },
                    color = White900
                ) {
                    Column(
                        Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Iniciar sesión",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            modifier = Modifier.padding(start = 30.dp, top = 20.dp, bottom = 10.dp)
                        )
                        LoginInput(
                            valueLabel = email,
                            textLabel = "Usuario",
                            imageVector = Icons.Default.Email
                        )
                        LoginInput(
                            valueLabel = password,
                            textLabel = "Contraseña",
                            imageVector = Icons.Rounded.Lock,
                            isTypePassword = true
                        )
                        LoginButton(
                            buttonTextValue = "Iniciar sesión",
                            paddingTopValue = 20.dp,
                            buttonColor = Green,
                            showProgress = false
                        ) {
                            if (email.value.isNotBlank()
                                && password.value.isNotBlank()
                            ) {
                                viewModel.loginWithEmailAndPassword(email.value, password.value, {
                                    goToDashboardScreen(email.value)
                                }, {
                                    scope.launch {
                                        snackBarHostState.showSnackbar("Los datos introducidos no son correctos")
                                    }
                                })

                            } else {
                                scope.launch {
                                    snackBarHostState.showSnackbar("Debes completar todos los campos")
                                }
                            }
                        }
                        LoginButton(
                            buttonTextValue = "Registrarme",
                            paddingTopValue = 5.dp,
                            paddingBotValue = 20.dp,
                            buttonColor = Violet,
                            showProgress = false
                        ) {
                            goToRegisterScreen()
                        }
                    }
                }
            }
            CustomSnackBar(
                snackBarHostState = snackBarHostState,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen({
        //no-op
    }, {
        //no-op
    })
}