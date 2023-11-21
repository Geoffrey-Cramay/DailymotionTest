package com.example.dailymotiontest.data.repository.parser

import com.example.dailymotiontest.core.model.Video
import com.example.dailymotiontest.data.remote.model.VideoResponse

interface VideosParser {
    fun parse(videosList: List<VideoResponse>): List<Video>
}
