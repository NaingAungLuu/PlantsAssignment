package com.androboy.plants.activities

import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.Window
import android.view.animation.AccelerateDecelerateInterpolator
import com.androboy.plants.R
import com.androboy.plants.adapters.FavTabPagerAdapter
import kotlinx.android.synthetic.main.activity_favorite.*
import kotlinx.android.synthetic.main.fragment_favourite.*

class FavouriteActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupTransition()
        setContentView(R.layout.activity_favorite)

        setSupportActionBar(tbFavourite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val tabPagerAdapter = FavTabPagerAdapter(supportFragmentManager)
        vpFavourite.adapter = tabPagerAdapter
        tabLayoutFavourite.setupWithViewPager(vpFavourite)
        tabLayoutFavourite.elevation = 0f


    }
    private fun setupTransition()
    {
        with(window)
        {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            val slideTransition = Slide()
            slideTransition.slideEdge = Gravity.BOTTOM
            slideTransition.duration = 1000
            slideTransition.interpolator = AccelerateDecelerateInterpolator()
            enterTransition = slideTransition
            exitTransition = slideTransition
        }
    }

}