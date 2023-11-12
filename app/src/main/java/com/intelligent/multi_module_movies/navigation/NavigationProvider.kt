package com.intelligent.multi_module_movies.navigation

import com.intelligent.feature.movie_details.ui.navigation.MovieDetailsApi
import com.intelligent.movie.ui.navigation.MovieApi

data class NavigationProvider(
    val movieApi: MovieApi,
    val movieDetailsApi: MovieDetailsApi
)
