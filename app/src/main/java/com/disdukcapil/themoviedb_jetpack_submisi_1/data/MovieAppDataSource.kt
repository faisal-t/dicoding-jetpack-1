package com.disdukcapil.themoviedb_jetpack_submisi_1.data

import androidx.lifecycle.LiveData
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.MovieEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.TvShowEntity

interface MovieAppDataSource {

    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getMovieById(movieId: String): LiveData<MovieEntity>

    fun getAllTvShows(): LiveData<List<TvShowEntity>>

    fun getTvShowById(tvShowId: String): LiveData<TvShowEntity>

}