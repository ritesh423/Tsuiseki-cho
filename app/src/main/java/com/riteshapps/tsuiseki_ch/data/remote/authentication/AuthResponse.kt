package com.riteshapps.tsuiseki_ch.data.remote.authentication

import com.google.gson.annotations.SerializedName

data class AuthResponse(
    @SerializedName("access_token")
    val accessToken: String,

    @SerializedName("refresh_token")
    val refreshToken: String,

    @SerializedName("expires_in")
    val expiresIn: Long,

    @SerializedName("token_type")
    val tokenType: String
)