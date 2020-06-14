package com.ekoo.bookapps.ui.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ekoo.bookapps.R
import com.ekoo.bookapps.adapter.ViewPagerAdapter
import com.ekoo.bookapps.utils.tabTitles
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        main_toolbar.setTitleTextColor(android.graphics.Color.WHITE)

        main_viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(main_tabLayout, main_viewPager){ tab, position ->
            tab.let {
                it.text = tabTitles[position]
            }
        }.attach()

    }
}