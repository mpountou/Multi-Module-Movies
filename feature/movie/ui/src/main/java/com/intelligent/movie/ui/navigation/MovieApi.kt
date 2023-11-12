package com.intelligent.movie.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.intelligent.core.feature_api.FeatureApi

interface MovieApi : FeatureApi {

}

class MovieApiImpl : MovieApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalMovieFeatureApi.registerGraph(
            navController, navGraphBuilder
        )
    }

}