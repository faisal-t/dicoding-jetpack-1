package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail

import androidx.lifecycle.ViewModel
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.DataEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.DataDummy

class DetailViewModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    private fun getListMovie(): ArrayList<DataEntity> =
            DataDummy.generateDummyMovies() as ArrayList<DataEntity>

    private fun getListTvShow(): ArrayList<DataEntity> =
            DataDummy.generateDummyTvShows() as ArrayList<DataEntity>

    fun setMovieId(movieId: String) {
        this.movieId = movieId
    }

    fun setTvShowId(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getDetailMovieById(): DataEntity {
        lateinit var result: DataEntity
        val listMovie = getListMovie()
        for (movie in listMovie) {
            if (movie.id == movieId) {
                result = movie
                break
            }
        }
        return  result
    }

    fun getDetailTvShowById(): DataEntity {
        lateinit var result: DataEntity
        val listTvShow = getListTvShow()
        for (tvShow in listTvShow) {
            if (tvShow.id == tvShowId) {
                result = tvShow
                break
            }
        }
        return result
    }


}