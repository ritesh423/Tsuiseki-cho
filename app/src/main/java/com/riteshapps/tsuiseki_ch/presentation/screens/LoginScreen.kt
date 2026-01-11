package com.riteshapps.tsuiseki_ch.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.riteshapps.tsuiseki_ch.presentation.auth.AuthViewModel

@Composable
fun LoginScreen(
    viewModel: AuthViewModel,
    onLoginSuccess: () -> Unit
) {
    val state = viewModel.uiState

    if (state.success) {
        LaunchedEffect(Unit) { onLoginSuccess() }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            value = state.username,
            onValueChange = {
                viewModel.updateUsername(it)
            },
            label = { Text("Email or Username") }
        )

        OutlinedTextField(
            value = state.password,
            onValueChange = {
                viewModel.updatePassword(it)
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.login(
                    state.username,
                    state.password
                )
            },
            enabled = !state.loading
        ) {
            Text("Login")
        }

        state.error?.let {
            Text(it, color = Color.Red)
        }
    }
}
