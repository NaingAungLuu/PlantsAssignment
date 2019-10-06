package com.androboy.plants.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.androboy.plants.fragments.FavouriteFragment

class FavTabPagerAdapter(
    fm: FragmentManager

) : FragmentPagerAdapter(fm , BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return FavouriteFragment()
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position)
        {
            0 -> "Recent"
            1 -> "Old"
            2 -> "Color"
            else -> "Album"
        }
    }

}