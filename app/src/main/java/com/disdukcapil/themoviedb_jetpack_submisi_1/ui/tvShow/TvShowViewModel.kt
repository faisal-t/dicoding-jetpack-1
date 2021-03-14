package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.disdukcapil.themoviedb_jetpack_submisi_1.data.MovieAppRepository
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.TvShowEntity


class TvShowViewModel(private val movieAppRepository: MovieAppRepository) : ViewModel() {

    fun getTvShow() : LiveData<List<TvShowEntity>> = movieAppRepository.getAllTvShows()

}