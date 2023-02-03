package com.example.paging3project.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.paging3project.datasource.local.dao.UnSplashImageDao
import com.example.paging3project.datasource.local.dao.UnSplashRemoteDao
import com.example.paging3project.datasource.local.entity.UnSplashImage
import com.example.paging3project.datasource.local.entity.UnSplashRemote
import com.example.paging3project.util.Constants.DATABASE_VERSION

@Database(entities = [UnSplashImage::class, UnSplashRemote::class], version = DATABASE_VERSION, exportSchema = false)
abstract class UnSplashDatabase :RoomDatabase(){
    abstract fun unSplashImageDao(): UnSplashImageDao
    abstract fun unSplashRemoteDao(): UnSplashRemoteDao
}