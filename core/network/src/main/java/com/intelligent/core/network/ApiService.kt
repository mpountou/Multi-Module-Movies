package com.intelligent.core.network

import com.intelligent.core.network.model.MovieDetailsResponse
import com.intelligent.core.network.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // https://api.themoviedb.org/3/search/movie?api_key=b5a4645bf883779776e39186b65581e3&query=Harry

    @GET("3/movie/now_playing")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
    ): MovieListResponse

    @GET("3/movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id : String,
        @Query("api_key") apiKey: String,
    ) : MovieDetailsResponse
}