package com.sdstudio.wordbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.add_word.*
import kotlinx.android.synthetic.main.fragment_word.*
import kotlinx.android.synthetic.main.fragment_word.view.*
import java.util.*


class word_fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(com.sdstudio.wordbook.R.layout.fragment_word, container, false)

        val adapter = addWordAdapter(loadData())
        view.recyclerView.adapter = adapter
        view.recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var dialog = dialog()
        floatingButton.setOnClickListener{
            fragmentManager?.let { it1 -> dialog.show(it1,"dialog")
                addwordButton?.setOnClickListener{
                    var word =addword.text.toString()
                    var mean =addmean.text.toString()
                    data(word,mean)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }



    //임의의 데이터
    fun loadData(): List<data>{
        val list = mutableListOf<data>()
            val data = data(word,mean)
            list.add(data)
        return list
    }
}





