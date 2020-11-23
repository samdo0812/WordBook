package com.sdstudio.wordbook.wordMVVM

import android.content.Context
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sdstudio.wordbook.databinding.WordFragmentItemBinding
import kotlinx.android.synthetic.main.word_fragment_item.view.*
import java.util.*

class WordAdapter(private var myDataset: List<WordEntity>?):RecyclerView.Adapter<ViewHolder>(){

    private var myDatasetFilter:List<WordEntity>

    init {
        myDatasetFilter = this!!.myDataset!!
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding
                = WordFragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return myDatasetFilter!!.size
    }

    fun getItem(): List<WordEntity>?{
        return myDatasetFilter
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(myDatasetFilter!!.get(position),position)
    }
}


class ViewHolder(val binding: WordFragmentItemBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(myDataset: WordEntity, position: Int){
        itemView.word.setText(myDataset.Word)
        itemView.mean.setText(myDataset.Mean)

    }
}