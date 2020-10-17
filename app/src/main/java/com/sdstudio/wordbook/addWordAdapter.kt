package com.sdstudio.wordbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.word_fragment_item.view.*

class addWordAdapter(val list: List <data>?) : RecyclerView.Adapter<Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.word_fragment_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list!!.get(position),position)
    }
}

class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(data: data, position: Int){
        itemView.word.setText(data.Word)
        itemView.mean.setText(data.Mean)
    }
}