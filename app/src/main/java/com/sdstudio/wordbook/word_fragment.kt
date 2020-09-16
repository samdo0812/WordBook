package com.sdstudio.wordbook

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_word.*

class word_fragment : Fragment() {
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
           /*
            fragment -> fragment
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.main, addword_fragment())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
            */

            //fragment -> Activity
            val intent = Intent(activity, addwordActivity::class.java)
            startActivity(intent)
        }
        super.onActivityCreated(savedInstanceState)
    }
}





