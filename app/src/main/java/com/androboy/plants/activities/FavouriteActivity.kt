package com.androboy.plants.activities

import android.os.Bundle
import com.androboy.plants.R
import com.androboy.plants.adapters.FavTabPagerAdapter
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.fragment_favourite.*

class FavouriteActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        setSupportActionBar(tbFavourite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val tabPagerAdapter = FavTabPagerAdapter(supportFragmentManager)
        vpFavourite.adapter = tabPagerAdapter
        tabLayoutFavourite.setupWithViewPager(vpFavourite)
        tabLayoutFavourite.elevation = 0f


    }

}