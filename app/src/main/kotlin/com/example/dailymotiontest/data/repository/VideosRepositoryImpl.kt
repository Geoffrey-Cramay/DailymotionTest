package com.example.dailymotiontest.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.dailymotiontest.core.VideosRepository
import com.example.dailymotiontest.core.model.Video
import com.example.dailymotiontest.data.paging.VideoPagingDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VideosRepositoryImpl @Inject constructor(private val pagingDataSource: VideoPagingDataSource) :
    VideosRepository {
    override suspend fun getVideos(): Flow<PagingData<Video>> = Pager(
        config = PagingConfig(pageSize = VideoPagingDataSource.LIMIT),
        pagingSourceFactory = { pagingDataSource }
    ).flow
}