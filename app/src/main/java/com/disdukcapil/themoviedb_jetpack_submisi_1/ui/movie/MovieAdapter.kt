package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.disdukcapil.themoviedb_jetpack_submisi_1.R
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.DataEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.databinding.ItemBinding
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail.ContentCallback
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail.DetailActivity

class MovieAdapter(private val callback: ContentCallback) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listMovie = ArrayList<DataEntity>()

    fun setMovie(movie : List<DataEntity>){
        if (movie.isNullOrEmpty()) return
        this.listMovie.clear()
        this.listMovie.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

    inner class MovieViewHolder(private val binding : ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(dataEntity: DataEntity){
            with(binding){
                tvTitle.text = dataEntity.title

               itemCard.setOnClickListener {
                   callback.onItemClicked(dataEntity)
               }

                Glide.with(itemView.context)
                        .load(dataEntity.imgPoster)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                                .error(R.drawable.ic_baseline_error_24))
                        .into(imgItemPhoto)

            }
        }

    }
}