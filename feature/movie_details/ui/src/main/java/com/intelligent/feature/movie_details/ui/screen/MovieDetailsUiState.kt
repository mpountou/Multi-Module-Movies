package com.intelligent.feature.movie_details.ui.screen

import com.intelligent.feature.movie_details.domain.model.MovieDetails

data class MovieDetailsUiState(
    val isLoading: Boolean = false,
    val error: String = "",
    val data: MovieDetails? = null
)
