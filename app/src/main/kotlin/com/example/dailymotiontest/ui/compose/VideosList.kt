package com.example.dailymotiontest.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.dailymotiontest.R
import com.example.dailymotiontest.presentation.VideoViewData


@Composable
fun VideosList(
    modifier: Modifier,
    videosList: List<VideoViewData>,
    onItemClick: (VideoViewData) -> Unit = {},
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
            items(videosList.size) {
                VideoListItem(videosList[it], onItemClick)
            }
        }
    }
}
