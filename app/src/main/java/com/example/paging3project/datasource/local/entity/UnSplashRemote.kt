package com.example.paging3project.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.paging3project.util.Constants.UNSPLASH_REMOTE_TABLE

@Entity(tableName = UNSPLASH_REMOTE_TABLE)
data class UnSplashRemote(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)
