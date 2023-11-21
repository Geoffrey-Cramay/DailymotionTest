package com.example.dailymotiontest.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.dailymotiontest.navigation.ArgKeys.VIDEO_TITLE_ARG_KEY
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
        composable(
            route = Screens.Player.route,
            arguments = listOf(navArgument(VIDEO_TITLE_ARG_KEY) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
//            val artistsViewModel: ArtistsViewModel =
//                backStackEntry.getViewModelFromEntry(Screens.Albums.route, navController)
//            PlayerScreen(
//                songId = backStackEntry.arguments?.getString(ALBUM_TITLE_ARG_KEY)
//                    ?: return@composable,
//                artistsViewModel = artistsViewModel
//            )
        }
    }
}

@Composable
private inline fun <reified T : ViewModel> NavBackStackEntry.getViewModelFromEntry(
    route: String,
    navController: NavHostController
): T {
    val parentEntry: NavBackStackEntry = remember(this) {
        navController.getBackStackEntry(route)
    }
    return hiltViewModel(parentEntry)
}
