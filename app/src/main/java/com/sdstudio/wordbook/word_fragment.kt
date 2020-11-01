package com.sdstudio.wordbook

import android.app.AlertDialog
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_word.*
import kotlinx.android.synthetic.main.add_word.view.*
import kotlinx.android.synthetic.main.fragment_word.*
import kotlinx.android.synthetic.main.fragment_word.view.*
import kotlinx.android.synthetic.main.word_fragment_item.*
import java.text.FieldPosition
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log

class word_fragment : Fragment() {

    private var list = ArrayList<data>()
    var adapter: addWordAdapter = addWordAdapter(list)
    //lateinit var adapter: addWordAdapter
    private lateinit var itemTouchHelper: ItemTouchHelper

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
        fab.attachToRecyclerView(recyclerView)

        //플로팅버튼
        fab.setOnClickListener {
            val mDialog = LayoutInflater.from(this.context).inflate(R.layout.add_word, null)
            val mbuilder = AlertDialog.Builder(this.context).setView(mDialog)
            val myAlertDialog = mbuilder.show()


            //다이얼로그 열기(단어등록)
            mDialog.addwordButton.setOnClickListener {
                val addword = mDialog.addword.text.toString()
                val addmean = mDialog.addmean.text.toString()

                //다이얼로그에 입력한 값
                list.add(data(addword, addmean))
                adapter = addWordAdapter(list)
                //setad(adapter)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
                view.recyclerView.layoutManager = LinearLayoutManager(context)
                myAlertDialog.dismiss()
                Log.d("test 다이얼로그",list.toString())
            }

            Log.d("test2 다이얼로그 밖, fab버튼 안",list.toString())

            //다이얼로그 취소
            mDialog.addwordCancel.setOnClickListener {
                myAlertDialog.dismiss()
            }
        }
        Log.d("test3 fab버튼 밖,프래그먼트 생성시",list.toString())
        //필터
        search_bar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.filter.filter(s)
            }
        })


        //itemTouchHelper = ItemTouchHelper(itemSwipe(adapter))
        //itemTouchHelper.attachToRecyclerView(recyclerView)
        Log.d("test4 아이템터치헬퍼 밑",list.toString())

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, position: Int) {
                adapter.removeItem(viewHolder)
            }
        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }
}