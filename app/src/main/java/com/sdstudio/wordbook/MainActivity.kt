package com.sdstudio.wordbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PagerAdapter(supportFragmentManager)
        adapter.addFragment(fragment1(), "My Word")
        adapter.addFragment(fragment2(), "Setting")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }
}
