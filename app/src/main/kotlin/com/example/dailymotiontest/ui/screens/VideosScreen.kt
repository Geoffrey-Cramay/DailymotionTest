package com.example.dailymotiontest.ui.screens

import com.example.dailymotiontest.presentation.VideoViewData
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.dailymotiontest.presentation.VideosViewModel
import com.example.dailymotiontest.ui.compose.VideosList

@Composable
fun VideosScreen(navController: NavHostController, viewModel: VideosViewModel) {
    LaunchedEffect(key1 = Unit) {
        viewModel.load()
    }

    val state: LazyPagingItems<VideoViewData> = viewModel.state.collectAsLazyPagingItems()
    VideosList(modifier = Modifier, state) {
        viewModel.load()
    }

//    DisplaySuccess(navController = navController, videoList = state)

//    when (val newState = state) {
//        VideosListViewState.Loading -> DisplayLoading()
//        VideosListViewState.Error -> DisplayError()
//        is VideosListViewState.Success -> DisplaySuccess(navController, newState.videoList)
//    }
}

@Composable
private fun DisplayLoading() {
    ""
}

@Composable
private fun DisplayError() {
    ""
}

//@Composable
//fun DisplaySuccess(navController: NavHostController, videoList: LazyPagingItems<VideoViewData>) {
//    VideosList(modifier = Modifier, videoList)
//    { video -> navController.navigate(Screens.Player.getPlayerScreenPath(video.title)) }
//}
