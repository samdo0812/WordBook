package com.sdstudio.wordbook.wordMVVM

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.sdstudio.wordbook.R

class WordAdddialog: DialogFragment(){

    lateinit var addword: String
    lateinit var addmean: String
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_word, container, false)
        return  view
    }
}