package com.sdstudio.wordbook.test

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdstudio.wordbook.R
import com.sdstudio.wordbook.wordMVVM.WordAdapter
import com.sdstudio.wordbook.wordMVVM.WordDatabase
import com.sdstudio.wordbook.wordMVVM.WordRepository
import com.sdstudio.wordbook.wordMVVM.WordViewModel

class TestActivity : AppCompatActivity() {

    private var db: WordDatabase? = null
    private var wordRepository: WordRepository? = null
    private var wordviewmodel: WordViewModel? = null
    private var bundle: Bundle? = null
    private var test01Fragment:Test01Fragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var fm = supportFragmentManager
        var fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.testLayout, Test01Fragment()).commit()


       /* db = WordDatabase.getInstance(this)
        wordviewmodel = ViewModelProvider(this).get(WordViewModel::class.java)
        wordviewmodel!!.getAll().observe(this, androidx.lifecycle.Observer {

        })*/
    }
}