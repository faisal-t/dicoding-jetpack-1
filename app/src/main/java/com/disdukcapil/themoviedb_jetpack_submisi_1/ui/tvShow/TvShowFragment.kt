package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.tvShow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.disdukcapil.themoviedb_jetpack_submisi_1.R
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.DataEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail.ContentCallback
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail.DetailActivity
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.helper
import kotlinx.android.synthetic.main.fragment_tv_show_frament.*


class TvShowFragment : Fragment(),ContentCallback {

    private lateinit var viewModel: TvShowViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_show_frament, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){
            viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tvShow = viewModel.getTvShow()

            val tvShowAdapter = TvShowAdapter(this@TvShowFragment)
            tvShowAdapter.setTvshow(tvShow)

            rv_tvshow.layoutManager = GridLayoutManager(context,2)
            rv_tvshow.setHasFixedSize(true)
            rv_tvshow.adapter = tvShowAdapter

        }
    }

    override fun onItemClicked(data: DataEntity) {
        startActivity(
                Intent(context, DetailActivity::class.java)
                        .putExtra(DetailActivity.EXTRA_DATA, data.id)
                        .putExtra(DetailActivity.EXTRA_TYPE, helper.TYPE_TVSHOW)
        )
    }
}