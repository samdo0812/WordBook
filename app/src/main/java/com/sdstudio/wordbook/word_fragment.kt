package com.sdstudio.wordbook

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_word.*

class word_fragment : Fragment() {

    var new_word: String? = null
    var modelList: String? = null

    companion object { // (1) 제일 먼저 호출됨
        @JvmStatic
        fun newInstance(new_word: String) =
            word_fragment().apply {
                arguments = Bundle().apply {
                    putString("new_word",new_word)
                    Log.d("test",this.toString())
                    //fragment를 반환
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            Log.d("test","언제 실행함?")
            arguments?.let {
                modelList = it.getString("new_word")
                Log.d("test",modelList.toString())
            }
            //test.setText(modelList)

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_word, container, false)
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {

        add_word.setOnClickListener {

            //fragment -> Activity
            val intent = Intent(activity, addwordActivity::class.java)
            startActivity(intent)
        }
        super.onActivityCreated(savedInstanceState)
    }
}





