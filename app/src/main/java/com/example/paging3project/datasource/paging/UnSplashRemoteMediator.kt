package com.example.paging3project.datasource.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.paging3project.datasource.local.UnSplashDatabase
import com.example.paging3project.datasource.local.dao.UnSplashImageDao
import com.example.paging3project.datasource.local.dao.UnSplashRemoteDao
import com.example.paging3project.datasource.local.entity.UnSplashImage
import com.example.paging3project.datasource.local.entity.UnSplashRemote
import com.example.paging3project.datasource.remote.api.UnSplashApi
import com.example.paging3project.util.Constants.ITEMS_PER_PAGE
import javax.inject.Inject

@ExperimentalPagingApi
class UnSplashRemoteMediator constructor(
    private val unSplashApi: UnSplashApi,
    private val unSplashDatabase: UnSplashDatabase,
    private val unSplashRemoteDao: UnSplashRemoteDao,
    private val unSplashImageDao: UnSplashImageDao
) : RemoteMediator<Int, UnSplashImage>() {

    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, UnSplashImage>
    ): MediatorResult {
        return try {
            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }
            }

            val response = unSplashApi.getAllImages(page = currentPage, perPage = ITEMS_PER_PAGE)
            val endOfPaginationReached = response.isEmpty()

            val prevPage = if (currentPage == 1) null else currentPage.minus(1)
            val nextPage = if (endOfPaginationReached) null else currentPage.plus(1)

            unSplashDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    unSplashImageDao.deleteAllImages()
                    unSplashRemoteDao.deleteAllImages()
                }
                val keys = response.map { unsplashImage ->
                    UnSplashRemote(
                        id = unsplashImage.id, prevPage = prevPage, nextPage = nextPage
                    )
                }
                unSplashRemoteDao.addAllRemote(remote = keys)
                unSplashImageDao.addImages(images = response)
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, UnSplashImage>
    ): UnSplashRemote? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                unSplashRemoteDao.getRemoteKey(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, UnSplashImage>
    ): UnSplashRemote? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { unsplashImage ->
                unSplashRemoteDao.getRemoteKey(id = unsplashImage.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, UnSplashImage>
    ): UnSplashRemote? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { unsplashImage ->
                unSplashRemoteDao.getRemoteKey(id = unsplashImage.id)
            }
    }
}