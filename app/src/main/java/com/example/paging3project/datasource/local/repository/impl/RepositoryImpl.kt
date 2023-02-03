package com.example.paging3project.datasource.local.repository.impl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paging3project.datasource.local.UnSplashDatabase
import com.example.paging3project.datasource.local.dao.UnSplashImageDao
import com.example.paging3project.datasource.local.dao.UnSplashRemoteDao
import com.example.paging3project.datasource.local.entity.UnSplashImage
import com.example.paging3project.datasource.local.repository.IRepository
import com.example.paging3project.datasource.paging.UnSplashRemoteMediator
import com.example.paging3project.datasource.remote.api.UnSplashApi
import com.example.paging3project.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class RepositoryImpl @Inject constructor(
    private val unSplashApi: UnSplashApi,
    private val unSplashDatabase: UnSplashDatabase,
    private val unSplashRemoteDao: UnSplashRemoteDao,
    private val unSplashImageDao: UnSplashImageDao
) : IRepository {
    override fun getAllImages(): Flow<PagingData<UnSplashImage>> {
        val pagingSourceFactory = { unSplashDatabase.unSplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = UnSplashRemoteMediator(
                unSplashApi = unSplashApi,
                unSplashDatabase = unSplashDatabase,
                unSplashRemoteDao = unSplashRemoteDao,
                unSplashImageDao = unSplashImageDao
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}