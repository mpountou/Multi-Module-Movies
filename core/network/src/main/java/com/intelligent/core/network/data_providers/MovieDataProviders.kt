package com.intelligent.core.network.data_providers

import com.intelligent.core.network.ApiService
import javax.inject.Inject

class MovieDataProviders @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMovieList(apiKey: String) =
        apiService.getMovieList(
            apiKey = apiKey
        )

    suspend fun getMovieDetails(id: String, apiKey: String) =
        apiService.getMovieDetails(
            id = id,
            apiKey = apiKey
        )
}