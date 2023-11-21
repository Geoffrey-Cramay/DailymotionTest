package com.example.dailymotiontest.navigation

import com.example.dailymotiontest.navigation.Routes.PLAYER_ROUTE
import com.example.dailymotiontest.navigation.Routes.VIDEOS_ROUTE

sealed class Screens(val route: String) {
    object Videos : Screens(VIDEOS_ROUTE)

    object Player : Screens(PLAYER_ROUTE)
}

object Routes {
    const val VIDEOS_ROUTE = "videos"
    const val PLAYER_ROUTE = "player"
}