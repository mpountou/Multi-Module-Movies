package com.intelligent.movie.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.intelligent.core.common.navigation_constants.MovieFeature
import com.intelligent.core.feature_api.FeatureApi
import com.intelligent.movie.ui.screen.MovieScreen
import com.intelligent.movie.ui.screen.MovieSearchViewModel

internal object InternalMovieFeatureApi : FeatureApi {
    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            startDestination = MovieFeature.movieScreenRoute,
            route = MovieFeature.nestedRoute
        ) {
            composable(MovieFeature.movieScreenRoute) {
                val viewModel: MovieSearchViewModel = hiltViewModel()
                MovieScreen(viewModel,navController)
            }
        }
    }
}