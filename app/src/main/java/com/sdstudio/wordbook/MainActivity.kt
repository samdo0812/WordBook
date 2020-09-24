package com.sdstudio.wordbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout.addTab(tabLayout.newTab().setText("My Word"))
        tabLayout.addTab(tabLayout.newTab().setText("Setting"))

        Log.d("test", "if")
        if (intent.hasExtra("plus_word")){
            Log.d("test","MainActivity")
            var newWord = intent.getStringExtra("plus_word")
            Log.d("test",newWord)
            val bundle:Bundle = Bundle()
            bundle.putString("newWord",newWord)
        }
        val pagerAdapter = PagerAdapter(supportFragmentManager,2)
        viewPager.adapter = pagerAdapter



        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.d("test", "flag")
                viewPager.currentItem = tab!!.position
            }
        })
        //페이저가 이동했을 때 탭도 이동시킴
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }
}
