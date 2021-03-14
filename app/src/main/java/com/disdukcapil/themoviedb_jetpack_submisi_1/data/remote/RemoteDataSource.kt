package com.disdukcapil.themoviedb_jetpack_submisi_1.data.remote

import android.util.Log
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.remote.response.Movie
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.remote.response.MovieResponse
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.remote.response.TvShow
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.remote.response.TvShowsResponse
import com.disdukcapil.themoviedb_jetpack_submisi_1.service.ApiConfig.ApiConfig
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
            ) {
                callback.onAllMoviesReceived(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(RemoteDataSource::class.simpleName, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getTvShows(callback: LoadTvShowsCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTvShows().enqueue(object : Callback<TvShowsResponse> {
            override fun onResponse(
                call: Call<TvShowsResponse>,
                response: Response<TvShowsResponse>
            ) {
                callback.onAllTvShowsReceived(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowsResponse>, t: Throwable) {
                Log.e(RemoteDataSource::class.simpleName, "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponses: List<Movie>?)
    }

    interface LoadTvShowsCallback {
        fun onAllTvShowsReceived(tvShowResponses: List<TvShow>?)
    }
}