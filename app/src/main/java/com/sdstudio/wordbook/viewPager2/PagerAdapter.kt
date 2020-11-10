package com.sdstudio.wordbook.viewPager2

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity ) : FragmentStateAdapter(fragmentActivity){

    val fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}
