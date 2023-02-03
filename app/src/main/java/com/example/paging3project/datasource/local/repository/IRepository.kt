package com.example.paging3project.datasource.local.repository

import androidx.paging.PagingData
import com.example.paging3project.datasource.local.entity.UnSplashImage
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getAllImages(): Flow<PagingData<UnSplashImage>>
}