package com.example.dailymotiontest.ui.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.dailymotiontest.R
import com.example.dailymotiontest.presentation.VideoViewData

@Composable
fun VideoImage(modifier: Modifier, viewData: VideoViewData?) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(viewData?.thumbnail)
            .crossfade(true)
            .error(R.drawable.ic_launcher_foreground)
//            .error(R.drawable.ic_no_photo)
            .build(),
        placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = viewData?.description,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}