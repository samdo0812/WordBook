package com.sdstudio.wordbook

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fragmentmanager:FragmentManager) :FragmentPagerAdapter(fragmentmanager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        when(position){
            0->{
                return word_fragment()
            }
            1->{
                return test_frgment()
            }
            2->{
                return setting_fragment()
            }
            else -> return word_fragment()
        }
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }


    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }
}
