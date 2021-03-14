package com.disdukcapil.themoviedb_jetpack_submisi_1.di

import com.disdukcapil.themoviedb_jetpack_submisi_1.data.MovieAppRepository
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.remote.RemoteDataSource

object Injection {
    fun provideRepository(): MovieAppRepository {

        val remoteRepository = RemoteDataSource.getInstance()

        return MovieAppRepository.getInstance(remoteRepository)
    }
}