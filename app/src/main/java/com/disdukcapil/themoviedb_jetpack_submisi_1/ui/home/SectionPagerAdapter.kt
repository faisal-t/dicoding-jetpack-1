package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.disdukcapil.themoviedb_jetpack_submisi_1.R
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.movie.MovieFragment
import com.disdukcapil.themoviedb_jetpack_submisi_1.ui.tvShow.TvShowFragment

class SectionPagerAdapter(private val context: Context,fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv_show)
    }

    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> MovieFragment()
            1 -> TvShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? = context.resources.getString(TAB_TITLES[position])

}