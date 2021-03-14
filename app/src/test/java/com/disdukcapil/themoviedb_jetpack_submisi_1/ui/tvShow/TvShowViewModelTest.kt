package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.tvShow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.MovieAppRepository
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
class TvShowViewModelTest {

    private lateinit var tvShowsViewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieAppRepository: MovieAppRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowEntity>>

    @Before
    fun setUp() {
        tvShowsViewModel = TvShowViewModel(movieAppRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShows = DataDummy.generateDummyTvShows()
        val tvShows = MutableLiveData<List<TvShowEntity>>()
        tvShows.value = dummyTvShows

        `when`(movieAppRepository.getAllTvShows()).thenReturn(tvShows)
        val tvShowEntities = tvShowsViewModel.getTvShow().value
        verify(movieAppRepository).getAllTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(3, tvShowEntities?.size)

        tvShowsViewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}