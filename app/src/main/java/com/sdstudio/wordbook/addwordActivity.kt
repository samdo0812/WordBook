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

            var plusword = plus_word.text.toString()
            //val bundle:Bundle = Bundle()
            //bundle.putString("plusword",plusword)
            //supportFragmentManager.beginTransaction().replace(R.id.viewPager, wordFragment).commit()
            //wordFragment.arguments = bundle


            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("plus_word",plusword)
            Log.d("test", plusword)
            startActivity(intent)
        }
    }
}
