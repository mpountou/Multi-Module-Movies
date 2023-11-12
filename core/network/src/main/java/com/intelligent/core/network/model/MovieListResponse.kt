package com.intelligent.core.network.model


import com.squareup.moshi.Json

data class MovieListResponse(
    @field:Json(name = "dates")
    var dates: Dates? = null,
    @field:Json(name = "page")
    var page: Int? = null,
    @field:Json(name = "results")
    var results: List<Result>? = null,
    @field:Json(name = "total_pages")
    var totalPages: Int? = null,
    @field:Json(name = "total_results")
    var totalResults: Int? = null
) {
    data class Dates(
        @field:Json(name = "maximum")
        var maximum: String? = null,
        @field:Json(name = "minimum")
        var minimum: String? = null
    )

    data class Result(
        @field:Json(name = "adult")
        var adult: Boolean? = null,
        @field:Json(name = "backdrop_path")
        var backdropPath: String? = null,
        @field:Json(name = "genre_ids")
        var genreIds: List<Int?>? = null,
        @field:Json(name = "id")
        var id: Int? = null,
        @field:Json(name = "original_language")
        var originalLanguage: String? = null,
        @field:Json(name = "original_title")
        var originalTitle: String? = null,
        @field:Json(name = "overview")
        var overview: String? = null,
        @field:Json(name = "popularity")
        var popularity: Double? = null,
        @field:Json(name = "poster_path")
        var posterPath: String? = null,
        @field:Json(name = "release_date")
        var releaseDate: String? = null,
        @field:Json(name = "title")
        var title: String? = null,
        @field:Json(name = "video")
        var video: Boolean? = null,
        @field:Json(name = "vote_average")
        var voteAverage: Double? = null,
        @field:Json(name = "vote_count")
        var voteCount: Int? = null
    )
}