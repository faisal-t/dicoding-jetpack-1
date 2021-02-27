package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.movie

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp(){
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovie() {

        val dataEntity = viewModel.getMovie()
        assertNotNull(dataEntity)
        assertEquals(10,dataEntity.size)

    }
}