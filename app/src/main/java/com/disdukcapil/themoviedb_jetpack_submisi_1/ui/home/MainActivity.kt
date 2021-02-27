package com.disdukcapil.themoviedb_jetpack_submisi_1.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.disdukcapil.themoviedb_jetpack_submisi_1.R
import com.disdukcapil.themoviedb_jetpack_submisi_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val sectionsPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        activityMainBinding.viewPager.adapter = sectionsPagerAdapter
        activityMainBinding.tabs.setupWithViewPager(activityMainBinding.viewPager)

        supportActionBar?.elevation = 0f

    }
}