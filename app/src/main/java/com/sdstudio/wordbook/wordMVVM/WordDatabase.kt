package com.sdstudio.wordbook.wordMVVM

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import java.lang.NullPointerException

abstract class WordDatabase(): RoomDatabase(){
    abstract fun wordDAO(): WordDAO

    companion object{
        var INSTANCE : WordDatabase? = null

        fun getInstance(context: Context): WordDatabase?{
            if (INSTANCE == null){
                synchronized(WordDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    WordDatabase::class.java,"word.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}