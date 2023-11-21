package com.example.dailymotiontest.data.remote

import com.example.dailymotiontest.data.remote.model.VideosResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class VideoVideoRemoteServiceImpl @Inject constructor(private val service: VideosService) : VideoRemoteService {
    override suspend fun getVideos(): Flow<VideosResponse> = flow {
        emit(service.getVideos(page = 1, limit = 10))
    }
}