package com.intelligent.feature.movie.data.repository

import com.intelligent.core.network.data_providers.MovieDataProviders
import com.intelligent.feature.movie.data.mapper.mapToDomain
import com.intelligent.feature.movie.domain.model.Movie
import com.intelligent.feature.movie.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieDataProviders: MovieDataProviders
) : MovieRepository {
    override suspend fun getMovieList(apiKey: String): List<Movie> =
       movieDataProviders.getMovieList(apiKey).mapToDomain()

}