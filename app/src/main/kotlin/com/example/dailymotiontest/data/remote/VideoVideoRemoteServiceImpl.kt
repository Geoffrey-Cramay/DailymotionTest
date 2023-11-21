package com.example.dailymotiontest.data.remote

import com.example.dailymotiontest.data.remote.model.VideosResponse
import javax.inject.Inject

class VideoVideoRemoteServiceImpl @Inject constructor(private val service: VideosService) :
    VideoRemoteService {
    override suspend fun getVideos(page: Int, limit: Int): VideosResponse =
        service.getVideos(page = page, limit = limit)
}

//on bougera le flow pour le retour du paging
