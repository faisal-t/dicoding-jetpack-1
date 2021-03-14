package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.MovieAppRepository
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.MovieEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.TvShowEntity
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
class DetailViewModelTest {

    private lateinit var detailViewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.id.toString()
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieAppRepository: MovieAppRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        detailViewModel = DetailViewModel(movieAppRepository)
        detailViewModel.setMovieId(movieId)
        detailViewModel.setTvShowId(tvShowId)
    }

    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(movieAppRepository.getMovieById(movieId)).thenReturn(movie)
        val movieEntity = detailViewModel.getDetailMovieById().value as MovieEntity
        verify(movieAppRepository).getMovieById(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.originalLanguage, movieEntity.originalLanguage)
        assertEquals(dummyMovie.id, movieEntity.id)
//        assertEquals(dummyMovie.popularity, movieEntity.popularity, dummyMovie.popularity)
//        assertEquals(dummyMovie.voteAverage, movieEntity.voteAverage, dummyMovie.voteAverage)
        assertEquals(dummyMovie.voteCount, movieEntity.voteCount)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)

        detailViewModel.getDetailMovieById().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShowDetail() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(movieAppRepository.getTvShowById(tvShowId)).thenReturn(tvShow)
        val tvShowEntity = detailViewModel.getDetailTvShowById().value as TvShowEntity
        verify(movieAppRepository).getTvShowById(tvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.name, tvShowEntity.name)
        assertEquals(dummyTvShow.firstAirDate, tvShowEntity.firstAirDate)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.originalLanguage, tvShowEntity.originalLanguage)
        assertEquals(dummyTvShow.id, tvShowEntity.id)
        assertEquals(dummyTvShow.popularity, tvShowEntity.popularity, dummyTvShow.popularity)
        assertEquals(dummyTvShow.voteAverage, tvShowEntity.voteAverage, dummyTvShow.voteAverage)
        assertEquals(dummyTvShow.voteCount, tvShowEntity.voteCount)
        assertEquals(dummyTvShow.posterPath, tvShowEntity.posterPath)

        detailViewModel.getDetailTvShowById().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }
}