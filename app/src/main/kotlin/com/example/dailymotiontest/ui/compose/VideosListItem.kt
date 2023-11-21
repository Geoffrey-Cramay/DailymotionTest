package com.example.dailymotiontest.ui.compose

import android.util.Log
import com.example.dailymotiontest.presentation.VideoViewData
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VideoListItem(
    videoViewData: VideoViewData,
    onItemClick: (VideoViewData) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { onItemClick(videoViewData) },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Row {
                VideoImage(
                    modifier = Modifier
                        .width(128.dp)
                        .height(104.dp)
                        .padding(end = 16.dp),
                    viewData = videoViewData,
                )
                Text(
                    modifier = Modifier.wrapContentWidth(),
                    text = videoViewData.title,
                    style = MaterialTheme.typography.titleSmall
                )
            }
            videoViewData.description.takeIf { it.isNotEmpty() }?.let { description ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 4.dp),
                text = videoViewData.creationTimeLabel,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}