package com.sdstudio.wordbook

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fragmentmanager:FragmentManager ,val tabCount:Int) :FragmentPagerAdapter(fragmentmanager) {

    override fun getItem(position: Int): Fragment {
        when(position){
            0->{
                return word_fragment()
            }
            1->{
                return setting_fragment()
            }
            else -> return word_fragment()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}
