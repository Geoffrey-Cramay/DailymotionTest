package com.example.dailymotiontest.presentation.mapper

import com.example.dailymotiontest.core.model.Video
import com.example.dailymotiontest.presentation.VideoViewData

interface VideosMapper {
    fun map(video: Video): VideoViewData
}