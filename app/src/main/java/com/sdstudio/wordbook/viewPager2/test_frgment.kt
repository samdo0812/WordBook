package com.sdstudio.wordbook.viewPager2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.sdstudio.wordbook.R
import com.sdstudio.wordbook.test.CustomAdapter
import com.sdstudio.wordbook.test.Item
import kotlinx.android.synthetic.main.fragment_test.*

class test_frgment: Fragment() {

    var adapter:CustomAdapter? = null
    var nameList = ArrayList<Item>()

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

        nameList.add(Item("test",R.drawable.img_intro))
        nameList.add(Item("test2",R.drawable.img_intro))
        nameList.add(Item("test3",R.drawable.img_intro))
        nameList.add(Item("test4",R.drawable.img_intro))

        adapter = CustomAdapter(nameList,context)
        gridView.adapter = adapter

        gridView.setOnItemClickListener{ adapterView, view, i, l ->
            Toast.makeText(context,i.toString(),Toast.LENGTH_LONG ).show()
        }
    }


}
