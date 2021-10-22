package com.isaacdelosreyes.firebaselogincompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.isaacdelosreyes.firebaselogincompose.ui.theme.LightGray

@Composable
fun LoginInput(textLabel: String, imageVector: ImageVector, isTypePassword: Boolean) {
    val valueLabel = remember { mutableStateOf("") }

    TextField(
        value = valueLabel.value,
        onValueChange = { text -> valueLabel.value = text },
        placeholder = { Text(text = textLabel) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 30.dp, end = 30.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(8.dp)),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            disabledIndicatorColor = LightGray,
            focusedIndicatorColor = LightGray,
            unfocusedIndicatorColor = LightGray
        ),
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = "Icono del campo de texto",
                tint = Color.Gray
            )
        },
        visualTransformation = if (isTypePassword) {
            PasswordVisualTransformation()

        } else {
            VisualTransformation.None
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}