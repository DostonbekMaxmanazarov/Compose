package com.example.paging3project.navigation

import com.example.paging3project.util.Constants.NAV_ARGUMENTS_IMAGE_URL

sealed class Screen(val root: String) {
    object Home : Screen("home_screen")
    object Search : Screen("search_screen")
    object Image : Screen("image_screen/{$NAV_ARGUMENTS_IMAGE_URL}") {
        fun passImageUrl(imageUrl: String): String {
            return "image_screen/$imageUrl"
        }
    }
}
