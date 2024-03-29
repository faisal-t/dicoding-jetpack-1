package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.disdukcapil.themoviedb_jetpack_submisi_1.R
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.DataEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail.ContentCallback
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail.DetailActivity
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.helper.TYPE_MOVIE
import kotlinx.android.synthetic.main.fragment_movie.*


class MovieFragment : Fragment(),ContentCallback {

    private lateinit var viewModel: MovieViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
            viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val movie = viewModel.getMovie()

            val movieAdapter = MovieAdapter(this@MovieFragment)
            movieAdapter.setMovie(movie)

            rv_movie.layoutManager = GridLayoutManager(context,2)
            rv_movie.setHasFixedSize(true)
            rv_movie.adapter = movieAdapter

        }

    }

    override fun onItemClicked(data: DataEntity) {
        startActivity(
                Intent(context, DetailActivity::class.java)
                        .putExtra(DetailActivity.EXTRA_DATA, data.id)
                        .putExtra(DetailActivity.EXTRA_TYPE,TYPE_MOVIE)
        )
    }


}