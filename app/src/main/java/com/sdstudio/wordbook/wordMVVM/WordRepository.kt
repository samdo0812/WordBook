package com.sdstudio.wordbook.wordMVVM

import androidx.lifecycle.LiveData

class WordRepository (private val wordDao: WordDAO) {

    val allWord: LiveData<List<WordEntity>> = wordDao.getAll()

    suspend fun insert(word: WordEntity) { wordDao.insert(word) }
}