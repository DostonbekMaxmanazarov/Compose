package com.example.paging3project.di.module

import androidx.paging.ExperimentalPagingApi
import com.example.paging3project.datasource.local.UnSplashDatabase
import com.example.paging3project.datasource.local.dao.UnSplashImageDao
import com.example.paging3project.datasource.local.dao.UnSplashRemoteDao
import com.example.paging3project.datasource.local.repository.IRepository
import com.example.paging3project.datasource.local.repository.impl.RepositoryImpl
import com.example.paging3project.datasource.remote.api.UnSplashApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@ExperimentalPagingApi
@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideImageRepository(
        unSplashApi: UnSplashApi,
        unSplashDatabase: UnSplashDatabase,
        unSplashRemoteDao: UnSplashRemoteDao,
        unSplashImageDao: UnSplashImageDao
    ): IRepository = RepositoryImpl(
        unSplashApi, unSplashDatabase, unSplashRemoteDao, unSplashImageDao
    )

}