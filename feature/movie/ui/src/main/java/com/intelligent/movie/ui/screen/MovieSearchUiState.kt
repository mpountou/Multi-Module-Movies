package com.intelligent.movie.ui.screen

import com.intelligent.feature.movie.domain.model.Movie

data class MovieSearchUiState(
    val isLoading: Boolean = false,
    val data: List<Movie>? = null,
    val error: String? = null
)
