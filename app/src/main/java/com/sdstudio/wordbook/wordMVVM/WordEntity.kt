package com.sdstudio.wordbook.wordMVVM

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "word")
data class WordEntity (
    //@PrimaryKey(autoGenerate = true)
    @PrimaryKey
    @ColumnInfo(name = "Word")
    var Word: String,
    @ColumnInfo(name = "Mean")
    var Mean: String
)
{

    //constructor(Word: String, Mean: String): this(Word, Mean, false)
}



