package com.example.paging3project.presentation.screen.bottom_navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomBottomNavigation(
    currentScreenId: String, onItemSelected: (BottomBarScreens) -> Unit
) {
    val items = BottomBarScreens.Items.screensList
    Box(
        contentAlignment = Alignment.BottomCenter,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 60.dp)
                .clip(CircleShape)
                .background(Color.Black.copy(alpha = 0.2f))
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            items.forEach {
                CustomBottomNavigationItem(
                    item = it, isSelected = it.route == currentScreenId
                ) {
                    onItemSelected(it)
                }
            }
        }
    }
}

@Composable
fun CustomBottomNavigationItem(
    item: BottomBarScreens, isSelected: Boolean, onClick: () -> Unit
) {
    val background =
        if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent

    val contentColor = if (isSelected) MaterialTheme.colors.primary else Color.White

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(imageVector = item.icon, contentDescription = null, tint = contentColor)
            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = item.title, color = contentColor
                )
            }
        }
    }
}

@Composable
@Preview
fun Prev1() {
    CustomBottomNavigationItem(BottomBarScreens.Home, true) {}
}

@Composable
@Preview
fun Prev2() { //CustomBottomNavigation(currentScreenId = BottomScreens.Home.id, window = , onItemSelected = {})
}