package com.example.paging3project.presentation.screen.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import com.example.paging3project.presentation.ui.theme.topAppBarBackgroundColor
import com.example.paging3project.presentation.ui.theme.topAppBarContentColor

@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit
) {
    TopAppBar(title = {
        Text(
            text = "Home", color = MaterialTheme.colors.topAppBarContentColor
        )
    }, backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor, actions = {
        IconButton(onClick = onSearchClicked) {
            Icon(
                imageVector = Icons.Default.Search, contentDescription = "Search Icon"
            )
        }
    })
}