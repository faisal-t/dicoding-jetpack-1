package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.tvShow

import androidx.lifecycle.ViewModel
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.DataEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.DataDummy

class TvShowViewModel : ViewModel() {

    fun getTvShow() : List<DataEntity> = DataDummy.generateDummyTvShows()

}