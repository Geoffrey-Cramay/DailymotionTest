package com.example.dailymotiontest.presentation

sealed class VideosListViewState {

    data class Success(val videoList: List<VideoViewData>) : VideosListViewState()
    object Loading : VideosListViewState()
    object Error : VideosListViewState()
}

data class VideoViewData(
    val id: String,
    val title: String,
    val description: String,
    val thumbnail: String,
    val link: String,
    val creationTimeLabel: String,
)