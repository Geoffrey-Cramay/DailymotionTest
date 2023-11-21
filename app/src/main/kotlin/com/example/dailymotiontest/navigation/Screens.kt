package com.example.dailymotiontest.navigation

import com.example.dailymotiontest.navigation.Routes.PLAYER_ROUTE
import com.example.dailymotiontest.navigation.Routes.VIDEOS_ROUTE

sealed class Screens(val route: String) {
    object Videos : Screens(VIDEOS_ROUTE)

    object Player : Screens("$PLAYER_ROUTE/{${ArgKeys.VIDEO_TITLE_ARG_KEY}}") {
        fun getPlayerScreenPath(videoId: String): String = "$PLAYER_ROUTE/$videoId"
    }
}

object Routes {
    const val VIDEOS_ROUTE = "videos"
    const val PLAYER_ROUTE = "player"
}

object ArgKeys {
    const val VIDEO_TITLE_ARG_KEY = "video_title_arg_key"
}