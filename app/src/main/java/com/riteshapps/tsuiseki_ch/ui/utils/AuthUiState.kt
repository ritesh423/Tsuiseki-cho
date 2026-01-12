package com.riteshapps.tsuiseki_ch.ui.utils

data class AuthUiState(
    val loading: Boolean = false,
    val success: Boolean = false,
    val error: String? = null
)
