package com.sdstudio.wordbook.wordMVVM

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface WordDAO{
    @Insert(onConflict = REPLACE) //인서트를 할때 프라이머리키가 똑같으면 덮어쓴다
    fun insert(word:WordEntity)

    @Query("SELECT * FROM word")
    fun getAll():LiveData<List<WordEntity>>
    //fun getAll():List<WordEntity>

    @Delete
    fun delete(word: WordEntity)
}