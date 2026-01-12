package com.riteshapps.tsuiseki_ch.data.repository

import com.riteshapps.tsuiseki_ch.data.remote.authentication.AuthApi
import com.riteshapps.tsuiseki_ch.data.remote.authentication.TokenStore
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: AuthApi,
    private val tokenStore: TokenStore
) {

    suspend fun login(
        username: String,
        password: String
    ): kotlin.Result<Unit> {
        return try {
            val response = api.login(username = username, password = password)

            tokenStore.saveTokens(
                response.accessToken,
                response.refreshToken
            )

            kotlin.Result.success(Unit)
        } catch (e: Exception) {
            kotlin.Result.failure(e)
        }
    }
}
