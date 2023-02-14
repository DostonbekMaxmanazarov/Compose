package com.example.paging3project.datasource.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import com.example.paging3project.util.Constants.UNSPLASH_IMAGE_TABLE
import kotlinx.serialization.SerialName

@Serializable
@Entity(tableName = UNSPLASH_IMAGE_TABLE)
data class UnSplashImage(
    @PrimaryKey(autoGenerate = false) val id: String,
    @Embedded @SerialName("urls") val unSplashUrls: UnSplashUrls? = null,
    val likes: Int? = null,
    @Embedded @SerialName("user") val unSplashUser: UnSplashUser? = null
)
