package com.intelligent.feature.movie_details.domain.repository

import com.intelligent.feature.movie_details.domain.model.MovieDetails

interface MovieDetailsRepository {

    suspend fun getMovieDetails(id: String, apiKey: String): MovieDetails

}