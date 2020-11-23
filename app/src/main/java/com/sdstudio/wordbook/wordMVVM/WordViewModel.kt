package com.sdstudio.wordbook.wordMVVM

import android.app.Application
import androidx.lifecycle.*


class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val wordRepository = WordRepository(application)
    private val words = wordRepository.getAll()

    fun getAll():LiveData<List<WordEntity>>{
        return this.words
    }

    fun insert(wordEntity: WordEntity){
        wordRepository.insert(wordEntity)
    }

    fun delete(wordEntity: WordEntity){
        wordRepository.delete(wordEntity)
    }

    /* var dataLiveData = MutableLiveData<List<WordEntity>>()
     private val data = arrayListOf<WordEntity>()
     //lateinit var wordDAO: WordDAO
      //var db: WordDatabase? = null

    fun addWord(addWord: String, addMean : String){
        val addWord = WordEntity(addWord, addMean)
        data.add(addWord)
        dataLiveData.value = data
    }

    init {
        val wordDAO = WordDatabase.getInstance(application)!!.wordDAO()
    }
*/

}