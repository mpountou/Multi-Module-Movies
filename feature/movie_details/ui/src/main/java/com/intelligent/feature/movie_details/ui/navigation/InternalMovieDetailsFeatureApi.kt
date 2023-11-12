package com.intelligent.feature.movie_details.ui.navigation


import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.intelligent.core.common.navigation_constants.MovieDetailsFeature
import com.intelligent.core.feature_api.FeatureApi
import com.intelligent.feature.movie_details.ui.screen.MovieDetailsScreen
import com.intelligent.feature.movie_details.ui.screen.MovieDetailsViewModel

internal object InternalMovieDetailsFeatureApi : FeatureApi {
    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(
            startDestination = MovieDetailsFeature.movieDetailsScreenRoute,
            route = MovieDetailsFeature.nestedRoute
        ) {
            composable(route = MovieDetailsFeature.movieDetailsScreenRoute) {
                val movieId = it.arguments?.getString("id").orEmpty()
                val viewModel = hiltViewModel<MovieDetailsViewModel>()
                MovieDetailsScreen(id = movieId, viewModel = viewModel)
            }
        }
    }
}