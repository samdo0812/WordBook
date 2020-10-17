package com.sdstudio.wordbook

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.add_word.*
import kotlinx.android.synthetic.main.add_word.view.*
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

        // val adapter = addWordAdapter()
        // view.recyclerView.adapter = adapter
        //view.recyclerView.layoutManager = LinearLayoutManager(context)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //var dialog = dialog()
        floatingButton.setOnClickListener {
            val mDialog = LayoutInflater.from(this.context).inflate(R.layout.add_word,null)
            val mbuilder = AlertDialog.Builder(this.context).setView(mDialog )
            val myAlertDialog = mbuilder.show()

            mDialog.addwordButton.setOnClickListener {

            }
            mDialog.addwordCancel.setOnClickListener {
                myAlertDialog.dismiss()
            }
        }
    }
}








