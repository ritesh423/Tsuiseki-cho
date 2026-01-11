package com.riteshapps.tsuiseki_ch.data.remote.authentication

import com.riteshapps.tsuiseki_ch.data.remote.authentication.AuthResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("oauth/token")
    suspend fun login(
        @Field("grant_type") grantType: String = "password",
        @Field("username") username: String,
        @Field("password") password: String
    ): AuthResponse
}