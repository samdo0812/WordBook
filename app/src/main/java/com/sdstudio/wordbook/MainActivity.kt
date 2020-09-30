package com.sdstudio.wordbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var wordfragment: Fragment
    var bundle = Bundle()

    val pagerAdapter = PagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent.hasExtra("plus_word")){
            Log.d("test","MainActivity")
            var new_Word = intent.getStringExtra("plus_word")
            Log.d("test",new_Word)
            Log.d("test","프래그먼트에 반영 가능?")
            wordfragment = word_fragment.newInstance(new_Word)
            pagerAdapter.addFragment(wordfragment, "My word")
            pagerAdapter.addFragment(test_frgment(), "test")
            pagerAdapter.addFragment(setting_fragment(), "setting")
            //viewPager.adapter = pagerAdapter
            //tabLayout.setupWithViewPager(viewPager)
        }
        else {
            Log.d("test", "어디어디서 호출되는지 확")
            pagerAdapter.addFragment(word_fragment(), "My word")
            pagerAdapter.addFragment(test_frgment(), "test")
            pagerAdapter.addFragment(setting_fragment(), "setting")
            //viewPager.adapter = pagerAdapter
            //tabLayout.setupWithViewPager(viewPager)
        }
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)


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
