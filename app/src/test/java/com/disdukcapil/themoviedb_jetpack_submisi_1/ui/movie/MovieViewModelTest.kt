package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.MovieAppRepository
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.MovieEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var moviesViewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieAppRepository: MovieAppRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        moviesViewModel = MovieViewModel(movieAppRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDummyMovies()
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = dummyMovies

        `when`(movieAppRepository.getAllMovies()).thenReturn(movies)
        val movieEntities = moviesViewModel.getMovie().value
        verify(movieAppRepository).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(3, movieEntities?.size)

        moviesViewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}