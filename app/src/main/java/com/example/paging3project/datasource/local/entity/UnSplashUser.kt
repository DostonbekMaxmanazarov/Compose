package com.example.paging3project.datasource.local.entity

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnSplashUser(
    @SerialName("links")
    @Embedded
    val unSplashUserLinks: UnSplashUserLinks?=null,
    @SerialName("username")
    val userName: String?=null
)
