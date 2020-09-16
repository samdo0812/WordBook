package com.sdstudio.wordbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_addword.*
import kotlinx.android.synthetic.main.activity_main.*

class addwordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addword)

        val wordFragment = word_fragment()

        addword.setOnClickListener {

            //var plusword = plus_word.text.toString()
            //val bundle:Bundle = Bundle()
            //bundle.putString("plusword",plusword)
            //supportFragmentManager.beginTransaction().replace(R.id.viewPager, wordFragment).commit()
            //wordFragment.arguments = bundle
            
            var Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }
    }
}
