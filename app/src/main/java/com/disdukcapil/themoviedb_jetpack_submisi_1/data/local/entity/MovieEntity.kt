package com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity

data class MovieEntity(
        val overview: String ?= null,
        val originalLanguage: String ?= null,
        val releaseDate: String ?= null,
        val popularity: Double ?= null,
        val voteAverage: Double ?= null,
        val id: Int ?= null,
        val title: String ?= null,
        val voteCount: Int ?= null,
        val posterPath: String ?= null
)
