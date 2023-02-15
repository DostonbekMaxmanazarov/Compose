package com.example.paging3project.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import coil.annotation.ExperimentalCoilApi
import com.example.paging3project.presentation.screen.bottom_navigation.BottomBarScreens
import com.example.paging3project.presentation.screen.bottom_navigation.CustomBottomNavigation
import com.example.paging3project.presentation.ui.theme.Paging3ProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalCoilApi
@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        super.onCreate(savedInstanceState)
        setContent {

            Paging3ProjectTheme {/*val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(color = Color.Transparent)
                    systemUiController.setNavigationBarColor(color = Color.Transparent)
                }
                val navController = rememberNavController()
                SetUpNavGraph(navController = navController)*/

                Column(modifier = Modifier.fillMaxSize().background(Color.Green)){
                    Scaffold(bottomBar = {
                        CustomBottomNavigation(
                            currentScreenId = BottomBarScreens.Home.route
                        ) {}
                    }) {}
                }

            }
        }
    }
}