package com.riteshapps.tsuiseki_ch.data.dtos.manga

import com.riteshapps.tsuiseki_ch.data.dtos.common.ImageDto
import com.riteshapps.tsuiseki_ch.data.dtos.common.TitlesDto

data class MangaAttributesDto(
    val slug: String?,
    val synopsis: String?,
    val titles: TitlesDto?,
    val canonicalTitle: String?,
    val abbreviatedTitles: List<String>?,
    val averageRating: String?,
    val ratingFrequencies: Map<String, String>?,
    val userCount: Int?,
    val favoritesCount: Int?,
    val startDate: String?,
    val endDate: String?,
    val popularityRank: Int?,
    val ratingRank: Int?,
    val ageRating: String?,
    val ageRatingGuide: String?,
    val status: String?,
    val posterImage: ImageDto?,
    val coverImage: ImageDto?,
    val chapterCount: Int?,
    val volumeCount: Int?,
    val mangaType: String?,
    val nsfw: Boolean?
)
