package com.example.paging3project.presentation.screen.bottom_navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.paging3project.presentation.screen.home.HomeScreen
import com.example.paging3project.presentation.screen.home.ProfileScreen
import com.example.paging3project.presentation.screen.home.SettingsScreen

@ExperimentalFoundationApi
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = BottomBarScreens.Home.route
    ) {
        composable(route = BottomBarScreens.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreens.Profile.route) {
            ProfileScreen()
        }
        composable(route = BottomBarScreens.Settings.route) {
            SettingsScreen()
        }
    }
}