package com.sdstudio.wordbook

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.add_word.*
import kotlinx.android.synthetic.main.add_word.view.*
import kotlinx.android.synthetic.main.fragment_word.*
import kotlinx.android.synthetic.main.fragment_word.view.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log


class word_fragment : Fragment() {
    //lateinit var addword:String
    //lateinit var addmean:String
    lateinit var adapter: addWordAdapter

    //fun setArrayList(list: ArrayList<data>){
      //  this.list = list
    //}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(com.sdstudio.wordbook.R.layout.fragment_word, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = ArrayList<data>()
        //플로팅버튼
        floatingButton.setOnClickListener {
            val mDialog = LayoutInflater.from(this.context).inflate(R.layout.add_word,null)
            val mbuilder = AlertDialog.Builder(this.context).setView(mDialog)
            val myAlertDialog = mbuilder.show()

            //다이얼로그 열기(단어등록)
            mDialog.addwordButton.setOnClickListener {
                val addword = mDialog.addword.text.toString()
                val addmean = mDialog.addmean.text.toString()

                //다이얼로그에 입력한 값
                //list =  arrayListOf(data(addword,addmean))
                list.add(data(addword,addmean))
                //Log.d("test",list.toString())

                //recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
                //recyclerView.adapter = addWordAdapter(list)

                adapter = addWordAdapter(list)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
                view.recyclerView.layoutManager = LinearLayoutManager(context)
                //setArrayList(list)
                myAlertDialog.dismiss()
            }

            //다이얼로그 취소
            mDialog.addwordCancel.setOnClickListener {
                myAlertDialog.dismiss()
            }
        }


    }
}












