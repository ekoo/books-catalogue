package com.ekoo.bookapps.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ekoo.bookapps.ui.genreListFragment.GenreListFragment
import com.ekoo.bookapps.ui.latestBooksFragment.LatestBooksFragment

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val fragmentList = listOf(
        LatestBooksFragment.newInstance(),
        GenreListFragment.newInstance()
    )

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}