package com.sdstudio.wordbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(word_fragment(), "My Word")
        adapter.addFragment(setting_fragment(), "Setting")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }
}
