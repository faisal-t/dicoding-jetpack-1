package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail

import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieId = dummyMovie.id
    private val tvshowId = dummyTvShow.id

    @Before
    fun setUp(){
        viewModel = DetailViewModel()
        viewModel.setMovieId(movieId)
        viewModel.setTvShowId(tvshowId)
    }


    @Test
    fun getDetailMovieById() {
        val movie = viewModel.getDetailMovieById()
        assertNotNull(movie)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.description, movie.description)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.releaseYear, movie.releaseYear)
        assertEquals(dummyMovie.imgPoster, movie.imgPoster)
    }

    @Test
    fun getDetailTvShowById() {
        val tvShow = viewModel.getDetailTvShowById()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.description, tvShow.description)
        assertEquals(dummyTvShow.genre, tvShow.genre)
        assertEquals(dummyTvShow.releaseYear, tvShow.releaseYear)
        assertEquals(dummyTvShow.imgPoster, tvShow.imgPoster)
    }
}