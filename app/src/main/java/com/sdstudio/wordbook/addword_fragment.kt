package com.sdstudio.wordbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_addword.*

class addword_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_addword, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        val wordFragment = word_fragment()

        back.setOnClickListener {
            var myword = myword.toString()
            val bundle:Bundle = Bundle()
            bundle.putString("myword",myword)

            val transaction = activity?.supportFragmentManager?.beginTransaction()
            wordFragment.arguments = bundle
            transaction?.replace(R.id.viewPager, word_fragment())
            transaction?.commit()
        }

        super.onActivityCreated(savedInstanceState)
    }
}
