package com.example.paging3project.presentation.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.example.paging3project.navigation.Screen
import com.example.paging3project.presentation.screen.common.ImageListContent

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController, homeViewModel: HomeViewModel = hiltViewModel()
) {
    val getAllImages = homeViewModel.getAllImages.collectAsLazyPagingItems()

    Scaffold(content = {
        ImageListContent(items = getAllImages) {
            navController.navigate(route = Screen.Image.passImageUrl(it))
        }
    })
}