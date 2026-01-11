package com.riteshapps.tsuiseki_ch.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.riteshapps.tsuiseki_ch.BottomNavigationItem
import com.riteshapps.tsuiseki_ch.theme.TsuisekichōTheme
import com.riteshapps.tsuiseki_ch.ui.utils.Screen
import kotlin.collections.contains

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBar = currentRoute in listOf(
        Screen.Anime.route,
        Screen.Manga.route,
        Screen.Search.route,
        Screen.Settings.route
    )


    TsuisekichōTheme {

        val items = listOf(
            BottomNavigationItem(
                screen = Screen.Anime,
                selectedIcon = Icons.Filled.Home,
                unSelectedIcon = Icons.Outlined.Home,
                hasNews = false
            ),
            BottomNavigationItem(
                screen = Screen.Manga,
                selectedIcon = Icons.Filled.ThumbUp,
                unSelectedIcon = Icons.Outlined.ThumbUp,
                hasNews = false
            ),
            BottomNavigationItem(
                screen = Screen.Search,
                selectedIcon = Icons.Filled.Search,
                unSelectedIcon = Icons.Outlined.Search,
                hasNews = false
            ),
            BottomNavigationItem(
                screen = Screen.Settings,
                selectedIcon = Icons.Filled.Settings,
                unSelectedIcon = Icons.Outlined.Settings,
                hasNews = false
            )
        )
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),

            topBar = {
                if (showBottomBar) {
                    TopAppBar(
                        title = {
                            Text(
                                text = items.firstOrNull {
                                    it.screen.route == currentRoute
                                }?.screen?.title ?: ""
                            )
                        }
                    )
                }
            },

            bottomBar = {
                if (showBottomBar) {
                    NavigationBar {
                        items.forEach { item ->
                            val selected = currentRoute == item.screen.route

                            NavigationBarItem(
                                selected = selected,
                                onClick = {
                                    navController.navigate(item.screen.route) {
                                        popUpTo(Screen.Anime.route)
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                label = { Text(item.screen.title) },
                                icon = {
                                    Icon(
                                        imageVector = if (selected)
                                            item.selectedIcon
                                        else
                                            item.unSelectedIcon,
                                        contentDescription = item.screen.title
                                    )
                                }
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->

            NavHost(
                navController,
                startDestination = Screen.Splash.route
            ) {

                composable(Screen.Splash.route) {
                    SplashScreen {
                        if (hasToken) {
                            navController.navigate(Screen.Home.route)
                        } else {
                            navController.navigate(Screen.Login.route)
                        }
                    }
                }

                composable(Screen.Login.route) {
                    LoginScreen {
                        navController.navigate(Screen.Anime.route) {
                            popUpTo(Screen.Login.route) { inclusive = true }
                        }
                    }
                }

                composable(Screen.Anime.route) { HomeScreen() }
            }

        }
    }
}