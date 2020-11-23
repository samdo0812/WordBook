package com.sdstudio.wordbook.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdstudio.wordbook.databinding.FragmentTest01Binding
import com.sdstudio.wordbook.databinding.Test01FragmentItemBinding
import com.sdstudio.wordbook.databinding.WordFragmentItemBinding
import com.sdstudio.wordbook.test.ViewHolder
import com.sdstudio.wordbook.wordMVVM.WordEntity
import kotlinx.android.synthetic.main.fragment_test01.view.*
import kotlinx.android.synthetic.main.test01_fragment_item.view.*
import kotlinx.android.synthetic.main.word_fragment_item.view.*

class TestAdapter(private var myDataset: List<WordEntity>?): RecyclerView.Adapter<ViewHolder>() {

    private var myDatasetFilter:List<WordEntity>

    init {
        myDatasetFilter = this!!.myDataset!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding
                = Test01FragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return myDatasetFilter!!.size
    }

    /*fun getItem(): List<WordEntity>?{
        return myDatasetFilter
    }*/
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myDatasetFilter!!.get(position),position)
    }
}


class ViewHolder(val binding: Test01FragmentItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(myDataset: WordEntity, position: Int){

       // itemView.answer02.text = myDataset.Mean
        //itemView.quiz.text = myDataset.Word
        itemView.answer01.text = myDataset.Mean
    }
}