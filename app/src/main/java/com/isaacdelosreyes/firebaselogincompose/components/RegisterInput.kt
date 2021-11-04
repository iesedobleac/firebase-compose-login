package com.isaacdelosreyes.firebaselogincompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isaacdelosreyes.firebaselogincompose.ui.theme.White900

@Composable
fun RegisterInput(valueLabel: MutableState<String>, textLabel: String, isTypePassword: Boolean = false) {
    TextField(
        value = valueLabel.value,
        onValueChange = { text -> valueLabel.value = text },
        placeholder = { Text(text = textLabel, style = TextStyle(fontSize = 14.sp)) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 30.dp, end = 30.dp)
            .clip(RoundedCornerShape(50.dp)),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = White900,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = if (isTypePassword) {
            PasswordVisualTransformation()

        } else {
            VisualTransformation.None
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true
    )
}