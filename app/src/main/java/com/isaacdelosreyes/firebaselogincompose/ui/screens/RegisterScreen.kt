package com.isaacdelosreyes.firebaselogincompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.isaacdelosreyes.firebaselogincompose.R
import com.isaacdelosreyes.firebaselogincompose.components.LoginButton
import com.isaacdelosreyes.firebaselogincompose.components.RegisterInput
import com.isaacdelosreyes.firebaselogincompose.ui.theme.LightBlack
import com.isaacdelosreyes.firebaselogincompose.ui.theme.Violet
import com.isaacdelosreyes.firebaselogincompose.ui.theme.White900

@Composable
fun RegisterScreen(goToLoginScreen: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "Background del login",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        ConstraintLayout() {

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
                        text = "Regístrate", style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = LightBlack
                        ), modifier = Modifier.padding(start = 30.dp, top = 20.dp, bottom = 10.dp)
                    )
                    RegisterInput(textLabel = "Nombre")
                    RegisterInput(textLabel = "Apellidos")
                    RegisterInput(textLabel = "Email")
                    RegisterInput(textLabel = "Introduce contraseña", isTypePassword = true)
                    RegisterInput(textLabel = "Repite contraseña", isTypePassword = true)
                    LoginButton(
                        buttonTextValue = "Registrarme",
                        paddingTopValue = 20.dp,
                        paddingBotValue = 20.dp,
                        buttonColor = Violet
                    ) {
                        goToLoginScreen()
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
    }
}

@Preview
@Composable
fun RegisterPreview() {
    RegisterScreen {
        //no-op
    }
}