package com.example.dailymotiontest.core

import com.example.dailymotiontest.core.model.Video
import kotlinx.coroutines.flow.Flow

interface VideosRepository {
    suspend fun getArtists(): Flow<List<Video>>
}