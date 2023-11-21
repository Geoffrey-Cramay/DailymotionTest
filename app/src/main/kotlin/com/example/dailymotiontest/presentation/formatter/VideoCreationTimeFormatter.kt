package com.example.dailymotiontest.presentation.formatter

import java.time.OffsetDateTime

interface VideoCreationTimeFormatter {
    fun format(creationTime: OffsetDateTime): String
}