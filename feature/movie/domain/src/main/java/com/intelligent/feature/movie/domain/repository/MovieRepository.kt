package com.intelligent.feature.movie.domain.repository

import com.intelligent.feature.movie.domain.model.Movie

interface MovieRepository {

    suspend fun getMovieList(apiKey: String) : List<Movie>

}