package com.example.dailymotiontest.presentation.mapper

import com.example.dailymotiontest.core.model.Video
import com.example.dailymotiontest.presentation.VideoViewData
import com.example.dailymotiontest.presentation.formatter.VideoCreationTimeFormatter
import javax.inject.Inject

class VideosMapperImpl @Inject constructor(
    private val formatter: VideoCreationTimeFormatter
) : VideosMapper {
    override fun map(video: Video): VideoViewData = with(video) {
        VideoViewData(
            id = id,
            title = title,
            description = description,
            thumbnail = thumbnail,
            link = link,
            creationTimeLabel = formatter.format(creationTime),
        )
    }
}