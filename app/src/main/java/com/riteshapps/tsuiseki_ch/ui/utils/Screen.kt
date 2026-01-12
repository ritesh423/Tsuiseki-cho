package com.riteshapps.tsuiseki_ch.ui.utils

sealed class Screen(val route: String, val title: String) {
    object Splash : Screen("splash", "")
    object Login : Screen("login", "")
    object Anime : Screen("anime", "Anime")
    object Manga : Screen("manga", "Manga")
    object Search : Screen("search", "Search")
    object Settings : Screen("settings", "Settings")
}

