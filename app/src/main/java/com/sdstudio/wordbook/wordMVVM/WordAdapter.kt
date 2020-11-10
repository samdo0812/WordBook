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
import java.util.*

class WordAdapter(private var myDataset: List<WordEntity>):RecyclerView.Adapter<ViewHolder>(),Filterable{

    private lateinit var myDatasetFilter:List<WordEntity>
    init {
        myDatasetFilter = myDataset
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding
                = WordFragmentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return myDatasetFilter.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.word.text =  myDatasetFilter.get(position).Word
        holder.binding.mean.text = myDatasetFilter.get(position).Mean

        //카드뷰 애니메이션
        val isExpandable : Boolean = myDatasetFilter[position].expandable
        holder.binding.expandableLayout.visibility = if (isExpandable) View.VISIBLE else  View.GONE
        holder.binding.linerLayout.setOnClickListener{
            val down = myDatasetFilter[position]
            down.expandable = !down.expandable
            notifyItemChanged(position)
        }

    }

    fun setData(newData: List<WordEntity>){
        myDataset = newData
        myDatasetFilter = myDataset
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val key: String = constraint.toString()
                if (key.isEmpty()){
                    myDatasetFilter = myDataset
                }
                else {
                    val isFiltered = mutableListOf<WordEntity>()
                    for(row:WordEntity in myDataset){
                        if(row.Word.toLowerCase().contains(key.toLowerCase())) {
                            isFiltered.add(row)
                        }

                    }
                    myDatasetFilter = isFiltered
                }
                var fil= FilterResults()
                fil.values = myDatasetFilter
                return fil
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                myDatasetFilter = results?.values as List<WordEntity>
                notifyDataSetChanged()
            }

        }
    }

}


class ViewHolder(val binding: WordFragmentItemBinding):RecyclerView.ViewHolder(binding.root){
    lateinit var mTTs: TextToSpeech

    //tts
    init {
        mTTs = TextToSpeech(itemView.context, TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR) {
                mTTs.language = Locale.US
            }
        })

        binding.speakBtn.setOnClickListener { v: View ->
            //get Text
            val toSpeak = binding.word.text.toString()
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