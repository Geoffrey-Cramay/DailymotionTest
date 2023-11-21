package com.example.dailymotiontest.ui.screens

import VideoViewData
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.dailymotiontest.presentation.VideoViewData
import com.example.dailymotiontest.presentation.VideosListViewState
import com.example.dailymotiontest.presentation.VideosViewModel
import com.example.dailymotiontest.ui.compose.VideosList

@Composable
fun VideosScreen(navController: NavHostController, viewModel: VideosViewModel) {
    LaunchedEffect(key1 = Unit) {
        viewModel.load()
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val newState = state) {
        VideosListViewState.Loading -> DisplayLoading()
        VideosListViewState.Error -> DisplayError()
        is VideosListViewState.Success -> DisplaySuccess(navController, newState.videoList)
    }
}

@Composable
private fun DisplayLoading() {
    ""
}

@Composable
private fun DisplayError() {
    ""
}

@Composable
fun DisplaySuccess(navController: NavHostController, videoList: List<VideoViewData>) {
    VideosList(modifier = Modifier, videoList)
//    { video -> navController.navigate(Screens.Player.getPlayerScreenPath(video.title)) }
}
