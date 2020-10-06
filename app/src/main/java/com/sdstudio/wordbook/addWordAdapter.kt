package com.sdstudio.wordbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.word_fragment_item.view.*

//class addWordAdapter(val list: List <data>) : RecyclerView.Adapter<Holder>() {
class addWordAdapter(val list: List<data>) : RecyclerView.Adapter<Holder>() {

    lateinit var arrayList : Array<data>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.word_fragment_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        //return arrayList.size
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //val data = arrayList[position]
        val data = list[position]
        holder.setItem(data)
    }
}

class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun setItem(data: data){
        itemView.word.text = data.Word
        itemView.mean.text = data.Mean
    }
}