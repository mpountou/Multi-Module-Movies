package com.intelligent.core.network.model


import com.squareup.moshi.Json

data class MovieDetailsResponse(
    @field:Json(name = "adult")
    var adult: Boolean? = null,
    @field:Json(name = "backdrop_path")
    var backdropPath: String? = null,
    @field:Json(name = "belongs_to_collection")
    var belongsToCollection: Any? = null,
    @field:Json(name = "budget")
    var budget: Int? = null,
    @field:Json(name = "genres")
    var genres: List<Genre>? = null,
    @field:Json(name = "homepage")
    var homepage: String? = null,
    @field:Json(name = "id")
    var id: Int? = null,
    @field:Json(name = "imdb_id")
    var imdbId: String? = null,
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
    @field:Json(name = "production_companies")
    var productionCompanies: List<ProductionCompany>? = null,
    @field:Json(name = "production_countries")
    var productionCountries: List<ProductionCountry>? = null,
    @field:Json(name = "release_date")
    var releaseDate: String? = null,
    @field:Json(name = "revenue")
    var revenue: Int? = null,
    @field:Json(name = "runtime")
    var runtime: Int? = null,
    @field:Json(name = "spoken_languages")
    var spokenLanguages: List<SpokenLanguage>? = null,
    @field:Json(name = "status")
    var status: String? = null,
    @field:Json(name = "tagline")
    var tagline: String? = null,
    @field:Json(name = "title")
    var title: String? = null,
    @field:Json(name = "video")
    var video: Boolean? = null,
    @field:Json(name = "vote_average")
    var voteAverage: Double? = null,
    @field:Json(name = "vote_count")
    var voteCount: Int? = null
) {
    data class Genre(
        @field:Json(name = "id")
        var id: Int? = null,
        @field:Json(name = "name")
        var name: String? = null
    )

    data class ProductionCompany(
        @field:Json(name = "id")
        var id: Int? = null,
        @field:Json(name = "logo_path")
        var logoPath: Any? = null,
        @field:Json(name = "name")
        var name: String? = null,
        @field:Json(name = "origin_country")
        var originCountry: String? = null
    )

    data class ProductionCountry(
        @field:Json(name = "iso_3166_1")
        var iso31661: String? = null,
        @field:Json(name = "name")
        var name: String? = null
    )

    data class SpokenLanguage(
        @field:Json(name = "english_name")
        var englishName: String? = null,
        @field:Json(name = "iso_639_1")
        var iso6391: String? = null,
        @field:Json(name = "name")
        var name: String? = null
    )
}