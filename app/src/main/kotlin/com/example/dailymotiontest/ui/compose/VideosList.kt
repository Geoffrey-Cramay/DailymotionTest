package com.example.dailymotiontest.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.dailymotiontest.R
import com.example.dailymotiontest.presentation.VideoViewData


@Composable
fun VideosList(
    modifier: Modifier,
    videosList: LazyPagingItems<VideoViewData>,
    onItemClick: (VideoViewData) -> Unit = {},
    onRetryButtonClick: () -> Unit = {},
) {
    with(videosList) {
        when {
            loadState.refresh is LoadState.Loading -> PageLoader(modifier = Modifier.fillMaxSize())
            loadState.refresh is LoadState.Error -> PageError(onRetryButtonClicked = onRetryButtonClick)
            else -> PageSuccess(
                modifier = modifier,
                videosList = this,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
private fun PageSuccess(
    modifier: Modifier,
    videosList: LazyPagingItems<VideoViewData>,
    onItemClick: (VideoViewData) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.title),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            style = MaterialTheme.typography.titleLarge
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(8.dp),
        ) {
            items(videosList.itemCount) { index ->
                VideoListItem(
                    videoViewData = videosList[index]!!,
                    onItemClick = onItemClick,
                )
            }
        }
    }
}

@Composable
fun PageLoader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(Modifier.padding(top = 10.dp))
    }
}

@Composable
fun PageError(
    modifier: Modifier = Modifier,
    onRetryButtonClicked: () -> Unit,
) {
    Row(
        modifier = modifier.padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.error_message),
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.weight(1f),
            maxLines = 2
        )
        OutlinedButton(onClick = onRetryButtonClicked) {
            Text(text = stringResource(id = R.string.action_retry))
        }
    }
}