package com.sdstudio.wordbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_addword.*
import kotlinx.android.synthetic.main.activity_main.*

class addwordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addword)
        val wordFragment = word_fragment()

        Log.d("test", "add word activity")
        addword.setOnClickListener {

            //입력된 단어
            var plusword = plus_word.text.toString()

            //경우1 addwordAcivity -> MainActivity
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("plus_word",plusword)
            Log.d("addword activity - test", plusword)
            startActivity(intent)


            //경우2 addwordActivity -> word_fragment
            //val bundle:Bundle = Bundle()
            //bundle.putString("plusword",plusword)
            //wordFragment.arguments = bundle
            //Log.d("addword activity - test", plusword)
        }
    }
}
