package com.example.paging3project.di.module

import android.content.Context
import androidx.room.Room
import com.example.paging3project.datasource.local.UnSplashDatabase
import com.example.paging3project.datasource.local.dao.UnSplashImageDao
import com.example.paging3project.datasource.local.dao.UnSplashRemoteDao
import com.example.paging3project.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): UnSplashDatabase {
        return Room.databaseBuilder(
            context, UnSplashDatabase::class.java, Constants.UNSPLASH_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideImageDao(database: UnSplashDatabase): UnSplashImageDao = database.unSplashImageDao()

    @Provides
    @Singleton
    fun provideRemoteDao(database: UnSplashDatabase): UnSplashRemoteDao =
        database.unSplashRemoteDao()
}