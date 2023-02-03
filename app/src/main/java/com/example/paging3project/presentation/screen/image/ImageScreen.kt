package com.example.paging3project.presentation.screen.image

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.paging3project.R
import com.example.paging3project.presentation.ui.theme.ImageBorderColor
import com.skydoves.cloudy.Cloudy

@ExperimentalCoilApi
@Composable
fun ImageScreen(navController: NavHostController, imageUrl: String) {
    val painter = rememberImagePainter(data = imageUrl) {
        crossfade(durationMillis = 500)
        error(R.drawable.ic_place_holder)
        placeholder(R.drawable.ic_place_holder)
    }
    Box(
        modifier = Modifier
            .blur(30.dp)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
            Image(
                painter = painter,
                contentDescription = "single image",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

        Surface(
            modifier = Modifier
                .padding(horizontal = 24.dp, vertical = 56.dp)
                .border(
                    border = BorderStroke(
                        1.dp,
                        ImageBorderColor
                    ), shape = RoundedCornerShape(8.dp)
                )
                .fillMaxSize(),
            elevation = 15.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = "single image",
                modifier = Modifier
                    .blur(30.dp)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}