package com.example.paging3project.presentation.screen.bottom_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreens(
    val route: String, val title: String, val icon: ImageVector
) {
    object Home : BottomBarScreens("home", "Home", Icons.Outlined.Home)
    object Search : BottomBarScreens("search", "Search", Icons.Outlined.Search)
    object Profile : BottomBarScreens("profile", "Profile", Icons.Outlined.Person)
    object Settings : BottomBarScreens("settings", "Settings", Icons.Outlined.Settings)

    object Items {
        val screensList = listOf(Home, Search, Profile, Settings)
    }
}