package com.example.paging3project.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.paging3project.datasource.local.entity.UnSplashImage
import com.example.paging3project.datasource.local.entity.UnSplashRemote

@Dao
interface UnSplashRemoteDao {

    @Query("SELECT * FROM UNSPLASH_REMOTE_TABLE Where id=:id")
    suspend fun getRemoteKey(id: String): UnSplashRemote

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemote(remote: List<UnSplashRemote>)

    @Query("DELETE FROM UNSPLASH_REMOTE_TABLE")
    suspend fun deleteAllImages()
}