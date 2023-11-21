package com.example.dailymotiontest.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.dailymotiontest.navigation.Screens
import com.example.dailymotiontest.presentation.VideoViewData
import com.example.dailymotiontest.presentation.VideosViewModel
import com.example.dailymotiontest.ui.compose.VideosList

@Composable
fun VideosScreen(navController: NavHostController, viewModel: VideosViewModel) {
    LaunchedEffect(key1 = Unit) {
        viewModel.load()
    }

    val videosList: LazyPagingItems<VideoViewData> = viewModel.state.collectAsLazyPagingItems()

    VideosList(
        modifier = Modifier.padding(top = 16.dp),
        videosList = videosList,
        onItemClick = { video -> navController.navigate(Screens.Player.route) },
        onRetryButtonClick = { viewModel.load() },
    )
}
