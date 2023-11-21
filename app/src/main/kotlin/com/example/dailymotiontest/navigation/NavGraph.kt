package com.example.dailymotiontest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dailymotiontest.ui.screens.PlayerScreen
import com.example.dailymotiontest.ui.screens.VideosScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Videos.route
    )
    {
        composable(route = Screens.Videos.route) {
            VideosScreen(navController = navController, viewModel = hiltViewModel())
        }
        composable(route = Screens.Player.route) {
            PlayerScreen()
        }
    }
}