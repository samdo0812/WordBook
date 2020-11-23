package com.sdstudio.wordbook.test

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdstudio.wordbook.R
import com.sdstudio.wordbook.databinding.FragmentTest01Binding
import com.sdstudio.wordbook.wordMVVM.WordAdapter
import com.sdstudio.wordbook.wordMVVM.WordDatabase
import com.sdstudio.wordbook.wordMVVM.WordRepository
import com.sdstudio.wordbook.wordMVVM.WordViewModel


class Test01Fragment : Fragment() {
    private var db: WordDatabase? = null
    private var wordViewModel: WordViewModel? = null
    private var adapter: TestAdapter? = null

    private lateinit var binding: FragmentTest01Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_test01, container, false
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewTest01.apply {
            db = WordDatabase.getInstance(context)
            //layoutManager = LinearLayoutManager(context)
            layoutManager = GridLayoutManager(context,2)
            binding.recyclerViewTest01.adapter = TestAdapter(emptyList())
        }

        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)
        wordViewModel!!.getAll().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            adapter = TestAdapter(it)
            binding.recyclerViewTest01.adapter = adapter
            Log.d("test",it[1].Word.toString())
        })

    }
}