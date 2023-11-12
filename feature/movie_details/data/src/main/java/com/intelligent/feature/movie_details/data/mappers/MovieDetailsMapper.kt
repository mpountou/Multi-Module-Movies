package com.intelligent.feature.movie_details.data.mappers

import com.intelligent.core.network.model.MovieDetailsResponse
import com.intelligent.feature.movie_details.domain.model.MovieDetails

fun MovieDetailsResponse.mapToDomain() = MovieDetails(
    title = this.title.orEmpty(),
    description = this.overview.orEmpty(),
    imageUrl = "https://image.tmdb.org/t/p/w500"+this.posterPath.orEmpty(),
)