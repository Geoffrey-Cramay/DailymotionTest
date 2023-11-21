package com.example.dailymotiontest.core

import androidx.paging.PagingData
import com.example.dailymotiontest.core.model.Video
import kotlinx.coroutines.flow.Flow

interface VideosInteractor {
    suspend fun getVideos(): Flow<PagingData<Video>>
}