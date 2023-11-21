package com.example.dailymotiontest.data.remote.model

import com.squareup.moshi.Json
import java.time.OffsetDateTime

data class VideosResponse(
    val page: Int,
    val limit: Int,
    val total: Int,
    val has_more: Boolean,
    val list: List<VideoResponse>
)

data class VideoResponse(
    val id: String,
    val title: String,
    val description: String,
    val thumbnail_url: String,
    val embed_url: String,
    @field:Json(name = "channel.created_time") val created_time: OffsetDateTime,
)