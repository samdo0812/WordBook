package com.sdstudio.wordbook.wordMVVM

import androidx.lifecycle.*
import com.sdstudio.wordbook.wordMVVM.WordEntity
import java.util.ArrayList

class WordViewModel: ViewModel(){

     val dataLiveData = MutableLiveData<List<WordEntity>>()
     private val data = arrayListOf<WordEntity>()

     fun addWord(addWord: String, addMean : String){
        val addWord = WordEntity(addWord, addMean)
         data.add(addWord)
         dataLiveData.value = data
    }
}