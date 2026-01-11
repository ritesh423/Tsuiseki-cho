package com.riteshapps.tsuiseki_ch.presentation.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.riteshapps.tsuiseki_ch.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    var uiState by mutableStateOf(AuthUiState())
        private set

    fun login(username: String, password: String) {
        viewModelScope.launch {
            uiState = uiState.copy(
                loading = true,
                error = null
            )

            repository.login(username, password)
                .onSuccess {
                    uiState = uiState.copy(
                        loading = false,
                        success = true
                    )
                }
                .onFailure {
                    uiState = uiState.copy(
                        loading = false,
                        error = "Invalid credentials"
                    )
                }
        }
    }
}
