package com.riteshapps.tsuiseki_ch.data.dtos.common

import com.google.gson.annotations.SerializedName

data class TitlesDto(
    val en: String?,
    @SerializedName("en_jp")
    val enJp: String?,
    @SerializedName("ja_jp")
    val jaJp: String?
)
