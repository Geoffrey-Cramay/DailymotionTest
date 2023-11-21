package com.example.dailymotiontest.presentation.mapper

import com.example.dailymotiontest.presentation.VideoViewData
import com.example.dailymotiontest.core.model.Video

interface VideosMapper {
    fun map(video: Video): VideoViewData
}