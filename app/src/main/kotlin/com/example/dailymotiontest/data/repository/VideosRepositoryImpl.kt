package com.example.dailymotiontest.data.repository

import com.example.dailymotiontest.core.VideosRepository
import com.example.dailymotiontest.core.model.Video
import com.example.dailymotiontest.data.remote.VideoRemoteService
import com.example.dailymotiontest.data.repository.parser.VideosParser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VideosRepositoryImpl @Inject constructor(
    private val dataSource: VideoRemoteService,
    private val parser: VideosParser
) :
    VideosRepository {
    override suspend fun getArtists(): Flow<List<Video>> = dataSource.getVideos().map { response ->
        parser.parse(response.list)
    }
}