package com.example.paging3project.datasource.remote.api

import com.example.paging3project.BuildConfig
import com.example.paging3project.datasource.local.entity.UnSplashImage
import com.example.paging3project.util.Constants.API_PHOTOS
import com.example.paging3project.util.Constants.API_SEARCH_PHOTOS
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnSplashApi {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET(API_PHOTOS)
    suspend fun getAllImages(
        @Query("page") page: Int, @Query("per_page") perPage: Int
    ): List<UnSplashImage>

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET(API_SEARCH_PHOTOS)
    suspend fun searchImages(
        @Query("page") page: Int, @Query("per_page") perPage: Int
    ): List<UnSplashImage>
}