package com.sdstudio.wordbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.word_fragment_item.view.*
import java.util.*

//class addWordAdapter(val list: List <data>?) : RecyclerView.Adapter<Holder>() {
class addWordAdapter(val list: ArrayList<data>) : RecyclerView.Adapter<Holder>() {

    //var list = ArrayList<data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.word_fragment_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.word.text = list.get(position).Word
        holder.mean.text = list.get(position).Mean
    }

    /*fun setArraylist(list:ArrayList<data>){
        this.list = list
    }*/
}

class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
    val word = itemView.findViewById<TextView>(R.id.word)
    val mean = itemView.findViewById<TextView>(R.id.mean )



}