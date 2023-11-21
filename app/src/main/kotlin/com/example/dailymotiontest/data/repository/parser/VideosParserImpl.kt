package com.example.dailymotiontest.data.repository.parser

import com.example.dailymotiontest.core.model.Video
import com.example.dailymotiontest.data.remote.model.VideoResponse

object VideosParserImpl : VideosParser {
    override fun parse(videosList: List<VideoResponse>): List<Video> =
        videosList.map {
            Video(
                id = it.id,
                title = it.title,
                description = it.description,
                thumbnail = it.thumbnail_url,
                link = it.embed_url,
                creationTime = it.created_time,
            )
        }
}