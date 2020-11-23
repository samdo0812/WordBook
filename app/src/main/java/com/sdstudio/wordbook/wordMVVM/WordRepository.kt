package com.sdstudio.wordbook.wordMVVM

import android.app.Application
import androidx.lifecycle.LiveData
import java.lang.Exception

class WordRepository (application: Application) {
    private val wordDatabase = WordDatabase.getInstance(application)!!
    private val wordDAO = wordDatabase.wordDAO()
    private val word = wordDAO.getAll()

    fun getAll(): LiveData<List<WordEntity>>{
        return word
    }

    fun insert(wordEntity: WordEntity){
        try {
            val thread = Thread(Runnable {
                wordDAO.insert(wordEntity)
            })
            thread.start()
        } catch (e: Exception){}
    }

    fun delete(wordEntity: WordEntity){
        try {
            val thread = Thread(Runnable {
                wordDAO.delete(wordEntity)
            })
            thread.start()
        }catch (e: Exception){}
    }

}