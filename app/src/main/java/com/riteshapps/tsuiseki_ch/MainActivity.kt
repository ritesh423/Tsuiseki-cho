package com.riteshapps.tsuiseki_ch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.riteshapps.tsuiseki_ch.presentation.screens.SplashScreen
import com.riteshapps.tsuiseki_ch.theme.TsuisekichōTheme

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TsuisekichōTheme {
//
//                val items = listOf(
//                    BottomNavigationItem(
//                        title = "Anime",
//                        selectedIcon = Icons.Filled.Home,
//                        unSelectedIcon = Icons.Outlined.Home,
//                        hasNews = false
//                    ),
//                    BottomNavigationItem(
//                        title = "Manga",
//                        selectedIcon = Icons.Filled.ThumbUp,
//                        unSelectedIcon = Icons.Outlined.ThumbUp,
//                        hasNews = false
//                    ),
//                    BottomNavigationItem(
//                        title = "Search",
//                        selectedIcon = Icons.Filled.Search,
//                        unSelectedIcon = Icons.Outlined.Search,
//                        hasNews = false
//                    ),
//                    BottomNavigationItem(
//                        title = "Settings",
//                        selectedIcon = Icons.Filled.Settings,
//                        unSelectedIcon = Icons.Outlined.Settings,
//                        hasNews = false
//                    )
//                )
//                var selectedItemIndex by rememberSaveable {
//                    mutableIntStateOf(0)
//                }
//
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//
//                    topBar = {
//                        TopAppBar(
//                            title = {
//                                Text(text = items[selectedItemIndex].title)
//                            },
//                            actions = {
//                                IconButton(onClick = {}) {
//                                    Icon(
//                                        imageVector = Icons.Filled.MoreVert,
//                                        contentDescription = "More"
//                                    )
//                                }
//                                IconButton(onClick = {}) {
//                                    Icon(
//                                        imageVector = Icons.Filled.Settings,
//                                        contentDescription = "Settings"
//                                    )
//                                }
//                                IconButton(onClick = {}) {
//                                    Icon(
//                                        imageVector = Icons.Filled.Menu,
//                                        contentDescription = "Menu"
//                                    )
//                                }
//                            },
//                            colors = TopAppBarDefaults.mediumTopAppBarColors(
//                                containerColor = MaterialTheme.colorScheme.primaryContainer,
//                                titleContentColor = MaterialTheme.colorScheme.primary
//                            )
//                        )
//                    },
//
//                    bottomBar = {
//                        NavigationBar {
//                            items.forEachIndexed { index, item ->
//                                NavigationBarItem(
//                                    selected = selectedItemIndex == index,
//                                    onClick = {
//                                        selectedItemIndex = index
//                                    },
//                                    label = {
//                                        Text(text = item.title)
//                                    },
//                                    icon = {
//                                        BadgedBox(
//                                            badge = {
//                                                when {
//                                                    item.badgeCount != null -> {
//                                                        Badge {
//                                                            Text(text = item.badgeCount.toString())
//                                                        }
//                                                    }
//
//                                                    item.hasNews -> {
//                                                        Badge()
//                                                    }
//                                                }
//                                            }
//                                        ) {
//                                            Icon(
//                                                imageVector =
//                                                    if (selectedItemIndex == index)
//                                                        item.selectedIcon
//                                                    else
//                                                        item.unSelectedIcon,
//                                                contentDescription = item.title
//                                            )
//                                        }
//                                    }
//                                )
//                            }
//                        }
//                    }
//                ) { innerPadding ->
//                    // Screen content will go here later
//                }
                SplashScreen { }
            }
        }
    }
}
