package com.example.dailymotiontest.data.remote

import com.example.dailymotiontest.data.remote.model.VideosResponse
import kotlinx.coroutines.flow.Flow

interface VideoRemoteService {
    suspend fun getVideos(page: Int, limit: Int): VideosResponse
}