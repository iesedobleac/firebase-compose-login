package com.isaacdelosreyes.firebaselogincompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomSnackBar(snackBarHostState: SnackbarHostState, modifier: Modifier) {
    SnackbarHost(
        hostState = snackBarHostState, snackbar = {
            Snackbar(
                content = {
                    Text(text = it.message)
                })
        },
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(Alignment.Top)
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
    )
}