package com.sdstudio.wordbook

import android.R
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.add_word.*
import kotlinx.android.synthetic.main.fragment_word.*
import kotlinx.android.synthetic.main.fragment_word.view.*


class word_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(com.sdstudio.wordbook.R.layout.fragment_word, container, false)

        val data: Array<data>
        val adapter = addWordAdapter(loadData())
        view.recyclerView.adapter = adapter
        view.recyclerView.layoutManager = LinearLayoutManager(context)

        floatingButton
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var dialog = dialog()
        floatingButton.setOnClickListener{
            fragmentManager?.let { it1 -> dialog.show(it1,"dialog") }
        }
    }



    //임의의 데이터
    fun loadData(): List<data>{
        val list = mutableListOf<data>()
        for (i in 0..50){
            val data = data("word $i","mean $i")
            list.add(data)
        }
        return list
    }
}





