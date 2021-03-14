package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.movie

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.disdukcapil.themoviedb_jetpack_submisi_1.R
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.DataEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.MovieEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.databinding.ItemBinding
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail.ContentCallback
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail.DetailActivity
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.helper.TYPE_MOVIE

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies.isNullOrEmpty()) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(listMovies[position])
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MovieViewHolder(private val binding : ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movieEntity: MovieEntity){
            with(binding){
                tvTitle.text = movieEntity.title
                Log.d("testing",movieEntity.toString())

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_TYPE,TYPE_MOVIE )
                        putExtra(DetailActivity.EXTRA_DATA, movieEntity.id.toString())
                    }
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                        .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${movieEntity.posterPath}")
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                                .error(R.drawable.ic_baseline_error_24))
                        .into(imgItemPhoto)

            }
        }

    }
}