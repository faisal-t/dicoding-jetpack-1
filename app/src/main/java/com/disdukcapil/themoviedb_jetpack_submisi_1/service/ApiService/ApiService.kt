package com.disdukcapil.themoviedb_jetpack_submisi_1.service.ApiService

import com.disdukcapil.themoviedb_jetpack_submisi_1.BuildConfig
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.remote.response.MovieResponse
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.remote.response.TvShowsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie?api_key=a72017f5eb7538fa169484d8df28b9ef")
    fun getMovies(
        @Query("api_key") apiKey: String = "a72017f5eb7538fa169484d8df28b9ef"
    ): Call<MovieResponse>

    @GET("tv?api_key=a72017f5eb7538fa169484d8df28b9ef")
    fun getTvShows(
        @Query("api_key") apiKey: String = "a72017f5eb7538fa169484d8df28b9ef"
    ): Call<TvShowsResponse>

}