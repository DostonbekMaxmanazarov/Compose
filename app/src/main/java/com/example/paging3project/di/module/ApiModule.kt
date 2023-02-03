package com.example.paging3project.di.module

import com.example.paging3project.datasource.remote.api.UnSplashApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideUnSplashApi(retrofit: Retrofit): UnSplashApi {
        return retrofit.create(UnSplashApi::class.java)
    }
}