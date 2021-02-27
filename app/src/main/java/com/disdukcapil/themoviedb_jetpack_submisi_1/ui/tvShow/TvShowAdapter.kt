package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.tvShow

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
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.movie.MovieAdapter
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.tvShow.TvShowAdapter.TvShowViewHolder

class TvShowAdapter(private val callback: ContentCallback) : RecyclerView.Adapter<TvShowViewHolder>() {

    private var listTv = ArrayList<DataEntity>()

    fun setTvshow(movie : List<DataEntity>){
        if (movie == null) return
        this.listTv.clear()
        this.listTv.addAll(movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TvShowViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val dataEntity = listTv[position]
        holder.bind(dataEntity)
    }

    override fun getItemCount(): Int = listTv.size

    inner class TvShowViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

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