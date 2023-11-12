package com.intelligent.multi_module_movies.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.intelligent.core.common.navigation_constants.MovieFeature

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AppNavGraph(
    navController: NavHostController,
    navigationProvider: NavigationProvider
) {
    NavHost(navController = navController, startDestination = MovieFeature.nestedRoute) {
        navigationProvider.movieApi.registerGraph(
            navController = navController,
            navGraphBuilder = this
        )
        navigationProvider.movieDetailsApi.registerGraph(
            navController = navController,
            navGraphBuilder = this
        )
    }
}