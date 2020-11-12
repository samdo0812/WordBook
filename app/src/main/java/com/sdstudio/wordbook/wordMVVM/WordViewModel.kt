package com.sdstudio.wordbook.wordMVVM

import android.app.Application
import androidx.lifecycle.*


class WordViewModel(application: Application) : AndroidViewModel(application) {

   /* private val repository: WordRepository
    val allWord: LiveData<List<WordEntity>>


    init {
        val wordDao:WordDAO = WordDatabase.getInstance(application)!!.wordDAO()
        repository = WordRepository(wordDao)
        allWord = repository.allWord
    }
*/

    val dataLiveData = MutableLiveData<List<WordEntity>>()
     private val data = arrayListOf<WordEntity>()


     fun addWord(addWord: String, addMean : String){
        val addWord = WordEntity(addWord, addMean)
         data.add(addWord)
         dataLiveData.value = data
     }



}