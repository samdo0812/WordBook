package com.sdstudio.wordbook

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_word.*
import kotlinx.android.synthetic.main.fragment_word.view.*

class word_fragment : Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_word, container, false)

        val adapter = addWordAdapter(loadData())
        view.recyclerView.adapter = adapter
        view.recyclerView.layoutManager = LinearLayoutManager(context)


        return view
    }

    //임의의 데이터
    fun loadData(): List<data>{
        val list = mutableListOf<data>()
        for (i in 0..50){
            val data = data(i,"word $i","mean $i")
            list.add(data)
        }
        return list
    }
}





