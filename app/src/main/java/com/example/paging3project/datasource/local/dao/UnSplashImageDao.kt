package com.example.paging3project.datasource.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paging3project.datasource.local.entity.UnSplashImage
import com.example.paging3project.util.Constants.UNSPLASH_IMAGE_TABLE

@Dao
interface UnSplashImageDao {

    @Query("SELECT * FROM $UNSPLASH_IMAGE_TABLE")
    fun getAllImages(): PagingSource<Int, UnSplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<UnSplashImage>)

    @Query("DELETE FROM $UNSPLASH_IMAGE_TABLE")
    suspend fun deleteAllImages()
}