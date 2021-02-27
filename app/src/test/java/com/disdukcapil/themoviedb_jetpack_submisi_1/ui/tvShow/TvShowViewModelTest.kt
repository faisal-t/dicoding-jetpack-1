package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.tvShow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp(){
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val dataEntity = viewModel.getTvShow()
        assertNotNull(dataEntity)
        assertEquals(10,dataEntity.size)
    }
}