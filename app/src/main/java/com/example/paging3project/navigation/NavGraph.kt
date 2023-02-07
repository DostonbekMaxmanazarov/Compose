package com.example.paging3project.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.example.paging3project.presentation.screen.home.HomeScreen
import com.example.paging3project.presentation.screen.detail.ImageScreen
import com.example.paging3project.util.Constants.NAV_ARGUMENTS_IMAGE_URL

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.root) {
        composable(route = Screen.Home.root) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Search.root) {
            //Search...
        }

        composable(
            route = Screen.Image.root,
            arguments = listOf(navArgument(NAV_ARGUMENTS_IMAGE_URL) {
                type = NavType.StringType
                defaultValue = ""
                nullable = true
            })
        ) {
            val imageUrl = it.arguments?.getString(NAV_ARGUMENTS_IMAGE_URL) ?: ""
            ImageScreen(navController = navController, imageUrl = imageUrl)
        }
    }
}
