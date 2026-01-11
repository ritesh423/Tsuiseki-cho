package com.riteshapps.tsuiseki_ch.data.remote.authentication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AuthRetrofitInstance {

    fun create(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://kitsu.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
