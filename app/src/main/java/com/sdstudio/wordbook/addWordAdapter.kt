package com.sdstudio.wordbook

import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.word_fragment_item.*
import kotlinx.android.synthetic.main.word_fragment_item.view.*
import java.util.*
import kotlin.collections.ArrayList

//class addWordAdapter(val list: List <data>?) : RecyclerView.Adapter<Holder>() {
class addWordAdapter: RecyclerView.Adapter<Holder> , Filterable {


     var list: ArrayList<data>
     var flist: ArrayList<data>

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

        //카드뷰 애니메이션
        val isExpandable : Boolean = flist[position].expandable
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else  View.GONE
        holder.linearLayout.setOnClickListener{
            val down = flist[position]
            down.expandable = !down.expandable
            notifyItemChanged(position)
        }
    }

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
    lateinit var mTTs: TextToSpeech
    var linearLayout:LinearLayout = itemView.findViewById(R.id.linerLayout)
    var expandableLayout: RelativeLayout = itemView.findViewById(R.id.expandable_layout)
    val word = itemView.findViewById<TextView>(R.id.word)
    val mean = itemView.findViewById<TextView>(R.id.mean)
    var speakBtn = itemView.findViewById<Button>(R.id.speakBtn)

    init {
        mTTs = TextToSpeech(itemView.context, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR) {
                mTTs.language = Locale.US
            }
        })

        speakBtn.setOnClickListener { v: View ->
               //get Text
                val toSpeak = word.text.toString()
                if (toSpeak == "") {
                    //텍스트가 없을 경우
                    Toast.makeText(itemView.context, "단어를 입력해 주세요.", Toast.LENGTH_LONG).show()

                } else {
                    mTTs.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
                    Toast.makeText(itemView.context, toSpeak, Toast.LENGTH_LONG).show()
                }

        }
    }
}