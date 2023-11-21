package com.example.dailymotiontest.core

import androidx.paging.PagingData
import com.example.dailymotiontest.core.model.Video
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VideosInteractorImpl @Inject constructor(private val repository: VideosRepository) :
    VideosInteractor {
    override suspend fun getVideos(): Flow<PagingData<Video>> = repository.getVideos()
}