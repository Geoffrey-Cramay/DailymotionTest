package com.example.dailymotiontest.core

import com.example.dailymotiontest.core.model.Video
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VideosInteractorImpl @Inject constructor(private val repository: VideosRepository) :
    VideosInteractor {
    override suspend fun getVideos(): Flow<List<Video>> = repository.getArtists()
}