package com.sdstudio.wordbook.viewPager2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.sdstudio.wordbook.R
import com.sdstudio.wordbook.test.TestActivity
import kotlinx.android.synthetic.main.fragment_test.*

class test_fragment: Fragment() {
    lateinit var fm: FragmentManager
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        test1.setOnClickListener{
            val intent = Intent(activity, TestActivity::class.java)
            startActivity(intent)
        }

    }

}
