package com.riteshapps.tsuiseki_ch.data.remote.authentication

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.riteshapps.tsuiseki_ch.data.local.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TokenStore(context: Context) {

    private val dataStore = context.dataStore

    suspend fun saveTokens(
        access: String,
        refresh: String
    ) {
        dataStore.edit { prefs ->
            prefs[TokenKeys.ACCESS_TOKEN] = access
            prefs[TokenKeys.REFRESH_TOKEN] = refresh
        }
    }

    fun accessTokenFlow(): Flow<String?> =
        dataStore.data.map { prefs ->
            prefs[TokenKeys.ACCESS_TOKEN]
        }

    suspend fun clearTokens() {
        dataStore.edit { it.clear() }
    }
}
