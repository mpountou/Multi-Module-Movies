package com.intelligent.feature.movie.data.mapper

import com.intelligent.core.network.model.MovieListResponse
import com.intelligent.feature.movie.domain.model.Movie

fun MovieListResponse.mapToDomain()
        : List<Movie> = this.results?.map {
    Movie(
        movieId = it.id?.toString().orEmpty(),
        imageUrl = "https://image.tmdb.org/t/p/w500" + it.posterPath
    )
} ?: emptyList()