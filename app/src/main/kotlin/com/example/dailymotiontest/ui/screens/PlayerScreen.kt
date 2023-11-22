package com.example.dailymotiontest.ui.screens

import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.net.Uri
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.annotation.OptIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ComponentActivity
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView


@OptIn(UnstableApi::class)
@Composable
fun PlayerScreen() {
    val context = LocalContext.current
    val uri = Uri.parse("https://cph-p2p-msl.akamaized.net/hls/live/2000341/test/master.m3u8")
    val configuration = LocalConfiguration.current
    val activity = context as ComponentActivity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE

    val exoPlayer = remember {
        ExoPlayer.Builder(context)
            .build()
            .apply {
                val defaultDataSourceFactory = DefaultDataSource.Factory(context)
                val dataSourceFactory: DataSource.Factory = DefaultDataSource.Factory(
                    context,
                    defaultDataSourceFactory
                )
                val source = HlsMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(MediaItem.fromUri(uri))
                setMediaSource(source)
                prepare()
            }
    }

    exoPlayer.apply {
        playWhenReady = true
        videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
        repeatMode = Player.REPEAT_MODE_ONE
    }

    DisposableEffect(
        AndroidView(
            factory = {
                PlayerView(context).apply {
                    hideController()
                    useController = true
                    resizeMode = when (configuration.orientation) {
                        Configuration.ORIENTATION_LANDSCAPE -> AspectRatioFrameLayout.RESIZE_MODE_FILL
                        else -> AspectRatioFrameLayout.RESIZE_MODE_FIT
                    }
                    player = exoPlayer
                    layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
                }
            })
    ) {
        onDispose {
            exoPlayer.release()
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        }
    }
}