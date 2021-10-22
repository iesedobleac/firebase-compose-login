package com.isaacdelosreyes.firebaselogincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.rounded.Lock
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
import com.isaacdelosreyes.firebaselogincompose.components.LoginButton
import com.isaacdelosreyes.firebaselogincompose.components.LoginInput
import com.isaacdelosreyes.firebaselogincompose.ui.theme.Green
import com.isaacdelosreyes.firebaselogincompose.ui.theme.Violet

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginParentView()
        }
    }
}

@Composable
fun LoginParentView() {
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

            val surface = createRef()

            Surface(
                Modifier
                    .fillMaxWidth()
                    .height(370.dp)
                    .clip(RoundedCornerShape(topStartPercent = 8, topEndPercent = 8))
                    .constrainAs(surface) {
                        bottom.linkTo(parent.bottom)
                    },
                color = Color.White
            ) {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Iniciar sesión", style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ), modifier = Modifier.padding(start = 30.dp, top = 20.dp)
                    )
                    LoginInput(textLabel = "Usuario", Icons.Default.Email, false)
                    LoginInput(textLabel = "Contraseña", Icons.Rounded.Lock, true)
                    LoginButton(
                        buttonTextValue = "Iniciar sesión",
                        paddingTopValue = 20.dp,
                        buttonColor = Green
                    ) {

                    }
                    LoginButton(
                        buttonTextValue = "Registrarme",
                        paddingTopValue = 5.dp,
                        buttonColor = Violet
                    ) {

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginParentView()
}