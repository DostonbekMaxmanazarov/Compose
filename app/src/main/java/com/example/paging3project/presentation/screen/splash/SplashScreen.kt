package com.example.paging3project.presentation.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.paging3project.R
import com.example.paging3project.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = Unit) {
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Home.root)
    }

    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.splash_photo),
            contentDescription = "splash_screen",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoadingAnimation(modifier = Modifier.padding(bottom = 120.dp))
        }
    }
}