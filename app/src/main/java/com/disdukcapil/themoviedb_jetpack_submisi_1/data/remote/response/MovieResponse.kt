package com.disdukcapil.themoviedb_jetpack_submisi_1.data.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse (

    @field:SerializedName("results")
    val results: List<Movie>
)


data class Movie(
        @field:SerializedName("overview")
        val overview: String,

        @field:SerializedName("original_language")
        val originalLanguage: String,

        @field:SerializedName("release_date")
        val releaseDate: String,

        @field:SerializedName("popularity")
        val popularity: Double,

        @field:SerializedName("vote_average")
        val voteAverage: Double,

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("title")
        val title: String,

        @field:SerializedName("vote_count")
        val voteCount: Int,

        @field:SerializedName("poster_path")
        val posterPath: String
)