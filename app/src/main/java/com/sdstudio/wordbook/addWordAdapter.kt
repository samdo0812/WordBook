package com.sdstudio.wordbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.word_fragment_item.view.*
import java.util.*
import kotlin.collections.ArrayList

//class addWordAdapter(val list: List <data>?) : RecyclerView.Adapter<Holder>() {
class addWordAdapter: RecyclerView.Adapter<Holder> , Filterable {


     lateinit var list: ArrayList<data>
     lateinit var flist: ArrayList<data>



    @JvmOverloads
    constructor (list: ArrayList<data>){
        this.list = list
        this.flist = list
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.word_fragment_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return flist.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.word.text = flist.get(position).Word
        holder.mean.text = flist.get(position).Mean
    }

    /*fun setArraylist(list:ArrayList<data>){
        this.list = list
    }*/


    override fun getFilter(): Filter {

        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val key: String = constraint.toString()
                if (key.isEmpty() ){
                    flist = list
                }
                else {
                    val isFiltered = ArrayList<data>()
                    for(row:data in list){
                        if(row.Word.toLowerCase().contains(key.toLowerCase())) {
                            isFiltered.add(row)
                        }

                    }
                    flist = isFiltered
                }
                var fil= FilterResults()
                fil.values = flist
                return fil
            }


            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                    flist = results?.values as ArrayList<data>
                   notifyDataSetChanged()
            }
        }
    }
}

class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
    val word = itemView.findViewById<TextView>(R.id.word)
    val mean = itemView.findViewById<TextView>(R.id.mean)



}