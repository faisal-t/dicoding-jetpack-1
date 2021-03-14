package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.tvShow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.disdukcapil.themoviedb_jetpack_submisi_1.R
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.DataEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.data.local.entity.TvShowEntity
import com.disdukcapil.themoviedb_jetpack_submisi_1.databinding.ItemBinding
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.detail.DetailActivity
import com.disdukcapil.themoviedb_jetpack_submisi_1.utils.helper


class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listTvShows = ArrayList<TvShowEntity>()

    fun setTvShows(tvShows: List<TvShowEntity>?) {
        if (tvShows.isNullOrEmpty()) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TvShowViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(listTvShows[position])
    }

    override fun getItemCount(): Int = listTvShows.size

    inner class TvShowViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShowEntity: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvShowEntity.name



                Glide.with(itemView.context)
                    .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${tvShowEntity.posterPath}")
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_baseline_refresh_24)
                            .error(R.drawable.ic_baseline_error_24)
                    )
                    .into(imgItemPhoto)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_TYPE, helper.TYPE_TVSHOW)
                        putExtra(DetailActivity.EXTRA_DATA, tvShowEntity.id.toString())
                    }

                    itemView.context.startActivity(intent)

                }
            }


        }
    }
}