package com.example.dailymotiontest.presentation.formatter

import com.example.dailymotiontest.core.model.Video
import com.example.dailymotiontest.presentation.VideoViewData
import java.time.OffsetDateTime

interface VideoCreationTimeFormatter {
    fun format(creationTime: OffsetDateTime): String
}