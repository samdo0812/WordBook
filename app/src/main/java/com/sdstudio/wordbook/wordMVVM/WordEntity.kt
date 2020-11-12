package com.sdstudio.wordbook.wordMVVM

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "word")
data class WordEntity (
    @PrimaryKey(autoGenerate = true)
    var Word: String,
    var Mean: String,
    var expandable: Boolean = false)
