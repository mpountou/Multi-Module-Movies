package com.intelligent.feature.movie_details.data.repository

import com.intelligent.core.network.data_providers.MovieDataProviders
import com.intelligent.feature.movie_details.data.mappers.mapToDomain
import com.intelligent.feature.movie_details.domain.model.MovieDetails
import com.intelligent.feature.movie_details.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class MovieDetailsRepositoryImpl @Inject constructor(
    private val movieDataProviders: MovieDataProviders
) : MovieDetailsRepository {
    override suspend fun getMovieDetails(id: String, apiKey: String): MovieDetails =
        movieDataProviders.getMovieDetails(id = id, apiKey = apiKey).mapToDomain()
}