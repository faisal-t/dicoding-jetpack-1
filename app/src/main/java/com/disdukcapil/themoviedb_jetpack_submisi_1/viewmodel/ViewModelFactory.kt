package com.disdukcapil.themoviedb_jetpack_submisi_1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.MovieAppRepository
import com.disdukcapil.themoviedb_jetpack_submisi_1.di.Injection
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail.DetailViewModel
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.movie.MovieViewModel
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.tvShow.TvShowViewModel

class ViewModelFactory private constructor(private val mMovieAppRepository: MovieAppRepository) :
        ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
                instance ?: synchronized(this) {
                    instance ?: ViewModelFactory(Injection.provideRepository())
                }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mMovieAppRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mMovieAppRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(mMovieAppRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: ${modelClass.name}")
        }
    }

}
