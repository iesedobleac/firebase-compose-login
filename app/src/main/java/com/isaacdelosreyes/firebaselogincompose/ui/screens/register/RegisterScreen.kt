package com.isaacdelosreyes.firebaselogincompose.ui.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.isaacdelosreyes.firebaselogincompose.R
import com.isaacdelosreyes.firebaselogincompose.components.CustomSnackBar
import com.isaacdelosreyes.firebaselogincompose.components.LoginButton
import com.isaacdelosreyes.firebaselogincompose.components.RegisterInput
import com.isaacdelosreyes.firebaselogincompose.ui.theme.LightBlack
import com.isaacdelosreyes.firebaselogincompose.ui.theme.Violet
import com.isaacdelosreyes.firebaselogincompose.ui.theme.White900
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun RegisterScreen(goToLoginScreen: () -> Unit) {
    val name = remember { mutableStateOf("") }
    val surname = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val showProgress = remember { mutableStateOf(false) }

    val nameValueEmpty = stringResource(id = R.string.name_value_empty)
    val surnameValueEmpty = stringResource(id = R.string.surname_value_empty)
    val emailValueEmpty = stringResource(id = R.string.email_value_empty)
    val passwordValueEmpty = stringResource(id = R.string.password_value_empty)
    val confirmPasswordValueEmpty = stringResource(id = R.string.confirm_password_value_empty)
    val passwordDoNotMatch = stringResource(id = R.string.password_do_not_match)

    val snackBarHostState = SnackbarHostState()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val viewModel = getViewModel<RegisterViewModel>()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_background),
                contentDescription = "Background del login",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            ConstraintLayout {

                val (surface, floatingButton) = createRefs()

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
                        Modifier.fillMaxSize()
                    ) {
                        Text(
                            text = "Regístrate",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = LightBlack
                            ),
                            modifier = Modifier.padding(start = 30.dp, top = 20.dp, bottom = 10.dp)
                        )
                        RegisterInput(valueLabel = name, textLabel = "Nombre")
                        RegisterInput(valueLabel = surname, textLabel = "Apellidos")
                        RegisterInput(valueLabel = email, textLabel = "Email")
                        RegisterInput(
                            valueLabel = password,
                            textLabel = "Introduce contraseña",
                            isTypePassword = true
                        )
                        RegisterInput(
                            valueLabel = confirmPassword,
                            textLabel = "Repite contraseña",
                            isTypePassword = true
                        )
                        LoginButton(
                            buttonTextValue = "Registrarme",
                            paddingTopValue = 20.dp,
                            paddingBotValue = 20.dp,
                            buttonColor = Violet,
                            showProgress = showProgress.value
                        ) {
                            if (password.value.isNotEmpty()
                                && confirmPassword.value.isNotEmpty()
                                && password.value == confirmPassword.value
                            ) {
                                showProgress.value = true
                                viewModel.registerNewUser(
                                    name.value,
                                    surname.value,
                                    email.value,
                                    password.value,
                                    {
                                        name.value = ""
                                        surname.value = ""
                                        email.value = ""
                                        password.value = ""
                                        confirmPassword.value = ""
                                        showProgress.value = false
                                    },
                                    {
                                        showProgress.value = false
                                        goToLoginScreen()
                                    })

                            } else {
                                scope.launch {
                                    when {
                                        name.value.isEmpty() -> {
                                            snackBarHostState.showSnackbar(nameValueEmpty)
                                        }
                                        surname.value.isEmpty() -> {
                                            snackBarHostState.showSnackbar(surnameValueEmpty)
                                        }
                                        email.value.isEmpty() -> {
                                            snackBarHostState.showSnackbar(emailValueEmpty)
                                        }
                                        password.value.isEmpty() -> {
                                            snackBarHostState.showSnackbar(passwordValueEmpty)
                                        }
                                        confirmPassword.value.isEmpty() -> {
                                            snackBarHostState.showSnackbar(confirmPasswordValueEmpty)
                                        }
                                        confirmPassword.value != password.value -> {
                                            snackBarHostState.showSnackbar(passwordDoNotMatch)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                FloatingActionButton(onClick = { goToLoginScreen() },
                    modifier = Modifier
                        .constrainAs(floatingButton) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.top)
                            end.linkTo(parent.end)
                        }
                        .padding(end = 20.dp)) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Retroceso al login",
                        tint = Color.White
                    )
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
fun RegisterPreview() {
    RegisterScreen {
        //no-op
    }
}