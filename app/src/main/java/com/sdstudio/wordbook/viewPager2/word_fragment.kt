package com.sdstudio.wordbook.viewPager2

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sdstudio.wordbook.R
import com.sdstudio.wordbook.wordMVVM.WordAdapter
import com.sdstudio.wordbook.wordMVVM.WordViewModel
import com.sdstudio.wordbook.databinding.FragmentWordBinding
import com.sdstudio.wordbook.wordMVVM.WordDatabase
import com.sdstudio.wordbook.wordMVVM.WordEntity
import kotlinx.android.synthetic.main.add_word.view.*
import kotlinx.android.synthetic.main.fragment_word.*
import kotlinx.android.synthetic.main.word_fragment_item.*
import java.util.*

class word_fragment : Fragment() {

    private lateinit var binding: FragmentWordBinding
    private lateinit var  wordviewmodel: WordViewModel
    private var db: WordDatabase? = null
    lateinit var adapter: WordAdapter
    lateinit var mTTs: TextToSpeech

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_word, container,false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.attachToRecyclerView(recyclerView)
        initSwipe()

        //플로팅버튼
        binding.fab.setOnClickListener {
            val mDialog = LayoutInflater.from(this.context).inflate(R.layout.add_word, null)
            val mbuilder = AlertDialog.Builder(this.context).setView(mDialog)
            val myAlertDialog = mbuilder.show()


            //다이얼로그 열기(단어등록)
            mDialog.addwordButton.setOnClickListener {
                var addword = mDialog.addword.text.toString()
                var addmean = mDialog.addmean.text.toString()
                val words = WordEntity(addword,addmean)
               /* wordviewmodel = ViewModelProvider(this).get(WordViewModel::class.java)
                wordviewmodel.addWord(addword, addmean)
            */

                if (addword.isNotEmpty() && addmean.isNotEmpty()){

                    //Thread(Runnable {
                        //db!!.wordDAO().insert(WordEntity(addword,addmean))
                        wordviewmodel.insert(words)
                    //}).start()
                }

                myAlertDialog.dismiss()
            }

            //다이얼로그 취소
            mDialog.addwordCancel.setOnClickListener {
                myAlertDialog.dismiss()
            }
        }

       binding.recyclerView.apply {
            db = WordDatabase.getInstance(context)
            layoutManager = LinearLayoutManager(context)
            binding.recyclerView.adapter = WordAdapter(emptyList())
        }

        wordviewmodel = ViewModelProvider(this).get(WordViewModel::class.java)
        wordviewmodel.getAll().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter = WordAdapter(it)
            binding.recyclerView.adapter = adapter
        })

        /*wordviewmodel.getAll().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter = WordAdapter(it)
            binding.recyclerView.adapter = adapter
        })*/
        /*db!!.wordDAO().getAll().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            //(binding.recyclerView.adapter as WordAdapter).setData(it)
            adapter = WordAdapter(it)
            binding.recyclerView.adapter = adapter
        })*/


    }

    //리사이클러뷰 아이템 스와이프
    private fun initSwipe(){
        val simpleItemTouchCallback: ItemTouchHelper.SimpleCallback = object :
            ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if (direction == ItemTouchHelper.LEFT){
                    Thread{
                        adapter?.getItem()?.get(position)?.let { db!!.wordDAO().delete(it) }
                    }.start()
                }
            }
        }

        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }
}