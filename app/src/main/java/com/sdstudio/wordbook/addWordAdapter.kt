package com.sdstudio.wordbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.word_fragment_item.view.*

class addWordAdapter(val list: List <data>) : RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.word_fragment_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = list[position]
        holder.setItem(data)
    }
}

class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun setItem(data: data){
        itemView.Number.text = "${data.No}"
        itemView.word.text = data.Word
        itemView.mean.text = data.Mean
    }
}