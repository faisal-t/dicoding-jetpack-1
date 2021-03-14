package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.disdukcapil.themoviedb_jetpack_submisi_1.R
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.MovieEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.TvShowEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.helper.TYPE_MOVIE
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.helper.TYPE_TVSHOW
import com.disdukcapil.themoviedb_jetpack_submisi_1.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var resultMovie: MovieEntity
    private lateinit var resultTvShow: TvShowEntity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvTitle : TextView = findViewById(R.id.tv_title)
        val tvDesc : TextView = findViewById(R.id.tv_desc)
        val tvRealaseDate : TextView = findViewById(R.id.tv_realase_date)
        val tvGenre : TextView = findViewById(R.id.tv_rating)


        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val id = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        Log.d("jenis",id.toString()+type.toString())

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            supportActionBar?.title = "Detail Film"
            viewModel.setMovieId(id.toString())
            viewModel.getDetailMovieById().observe(this,{resultMovie ->
                tvTitle.text = resultMovie.title
                tvDesc.text = resultMovie.overview
                tvRealaseDate.text = resultMovie.releaseDate
                tvGenre.text = resultMovie.voteAverage.toString()

                Glide.with(this@DetailActivity)
                        .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${resultMovie.posterPath.toString()}")
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                                .error(R.drawable.ic_baseline_error_24))
                        .into(img_item_photo)

                Glide.with(this@DetailActivity)
                        .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${resultMovie.posterPath.toString()}")
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                                .error(R.drawable.ic_baseline_error_24))
                        .into(img_item_preview)

                Log.d("gambar",resultMovie.posterPath.toString())
            })

        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            supportActionBar?.title = "Detail TvShow"
            viewModel.setTvShowId(id.toString())
            viewModel.getDetailTvShowById().observe(this,{resultTvShow ->
                tvTitle.text = resultTvShow.name
                tvDesc.text = resultTvShow.overview
                tvRealaseDate.text = resultTvShow.firstAirDate
                tvGenre.text = resultTvShow.voteAverage.toString()

                Glide.with(this@DetailActivity)
                        .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${resultTvShow.posterPath}")
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                                .error(R.drawable.ic_baseline_error_24))
                        .into(img_item_photo)

                Glide.with(this@DetailActivity)
                        .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${resultTvShow.posterPath}")
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                                .error(R.drawable.ic_baseline_error_24))
                        .into(img_item_preview)

            })

        }




//        Log.d("asd",result.toString())





    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}