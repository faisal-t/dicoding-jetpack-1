package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.movie

import androidx.lifecycle.ViewModel
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.DataEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovie() : List<DataEntity> = DataDummy.generateDummyMovies()


}
