package com.sdstudio.wordbook

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PagerAdapter(this )
        val fragments = listOf<Fragment>(word_fragment(),test_frgment(),setting_fragment())
        val tabTitles = listOf<String>("My word", "Test", "Setting")

        adapter.fragments.addAll(fragments)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}
