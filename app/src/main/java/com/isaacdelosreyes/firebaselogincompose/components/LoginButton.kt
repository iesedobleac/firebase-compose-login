package com.isaacdelosreyes.firebaselogincompose.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginButton(
    buttonTextValue: String,
    paddingTopValue: Dp,
    paddingBotValue: Dp = 0.dp,
    buttonColor: Color,
    buttonClick: () -> Unit
) {
    Button(
        onClick = { buttonClick() },
        Modifier
            .padding(
                top = paddingTopValue,
                start = 30.dp,
                end = 30.dp,
                bottom = paddingBotValue
            )
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(50.dp)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = buttonColor
        ),
        contentPadding = PaddingValues()
    ) {
        Text(
            text = buttonTextValue,
            style = TextStyle(
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}