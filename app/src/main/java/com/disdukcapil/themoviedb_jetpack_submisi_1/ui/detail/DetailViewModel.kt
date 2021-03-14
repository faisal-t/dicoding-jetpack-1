package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.DataEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.MovieAppRepository
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.MovieEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.TvShowEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.DataDummy

class DetailViewModel(private val movieAppRepository: MovieAppRepository) : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String


    fun setMovieId(movieId: String) {
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getDetailMovieById(): LiveData<MovieEntity> = movieAppRepository.getMovieById(movieId)


    fun getDetailTvShowById(): LiveData<TvShowEntity> =  movieAppRepository.getTvShowById(tvShowId)


}