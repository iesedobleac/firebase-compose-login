package com.isaacdelosreyes.firebaselogincompose.ui.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.isaacdelosreyes.firebaselogincompose.R
import com.isaacdelosreyes.firebaselogincompose.ui.theme.Violet
import com.isaacdelosreyes.firebaselogincompose.ui.theme.White900

@Composable
fun DashboardScreen(email: String?) {
    Image(
        painter = painterResource(id = R.drawable.login_background),
        contentDescription = "Background del login",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {

            val (surface) = createRefs()

            Surface(
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .constrainAs(surface) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                shape = RoundedCornerShape(8),
                color = White900
            ) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp, bottom = 20.dp, start = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_image),
                        contentDescription = "Image de perfil",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp, 80.dp)
                            .clip(RoundedCornerShape(50))
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 30.sp,
                                    color = Violet,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("Bienvenido\n ")
                            }
                            append("$email")
                        },
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewScreen() {
    DashboardScreen("isaacdelosredi@gmail.com")
}