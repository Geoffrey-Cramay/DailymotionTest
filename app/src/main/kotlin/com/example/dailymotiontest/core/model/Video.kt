package com.example.dailymotiontest.core.model

import java.time.OffsetDateTime

data class Video(
    val id: String,
    val title: String,
    val description: String,
    val thumbnail: String,
    val link: String,
    val creationTime: OffsetDateTime,
)