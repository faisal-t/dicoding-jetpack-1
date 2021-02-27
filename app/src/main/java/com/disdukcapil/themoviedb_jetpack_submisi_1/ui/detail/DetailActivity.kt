package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.disdukcapil.themoviedb_jetpack_submisi_1.R
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.DataEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.databinding.ActivityDetailBinding
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.helper.TYPE_MOVIE
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.helper.TYPE_TVSHOW
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.helper.setGlideImage
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var result: DataEntity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvTitle : TextView = findViewById(R.id.tv_title)
        val tvDesc : TextView = findViewById(R.id.tv_desc)
        val tvRealaseDate : TextView = findViewById(R.id.tv_realase_date)
        val tvGenre : TextView = findViewById(R.id.tv_genre)

        val viewModel = ViewModelProvider(this@DetailActivity, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val id = intent.getStringExtra(EXTRA_DATA)
        val type = intent.getStringExtra(EXTRA_TYPE)

        if (type.equals(TYPE_MOVIE, ignoreCase = true)) {
            id?.let {
                viewModel.setMovieId(it)
            }
            result = viewModel.getDetailMovieById()
        } else if (type.equals(TYPE_TVSHOW, ignoreCase = true)) {
            id?.let {
                viewModel.setTvShowId(it)
            }
            result = viewModel.getDetailTvShowById()
        }

        supportActionBar?.title = "Detail Film"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        Log.d("asd",result.toString())

        tvTitle.text = result.title
        tvDesc.text = result.description
        tvRealaseDate.text = result.releaseYear
        tvGenre.text = result.genre
        setGlideImage(this@DetailActivity, result.imgPoster, img_item_photo)
        setGlideImage(this@DetailActivity, result.imgPoster, img_item_preview)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}