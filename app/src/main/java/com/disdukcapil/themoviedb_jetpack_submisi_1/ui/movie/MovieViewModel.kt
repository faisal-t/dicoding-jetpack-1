package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.DataEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.MovieAppRepository
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.MovieEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.DataDummy

class MovieViewModel (private val movieAppRepository: MovieAppRepository) : ViewModel() {

    fun getMovie() : LiveData<List<MovieEntity>> = movieAppRepository.getAllMovies()


}
