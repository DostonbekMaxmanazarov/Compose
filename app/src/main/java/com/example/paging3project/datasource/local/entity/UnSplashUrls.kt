package com.example.paging3project.datasource.local.entity

import kotlinx.serialization.Serializable

@Serializable
data class UnSplashUrls(
    val regular: String?=null,
    val full: String?=null
)
