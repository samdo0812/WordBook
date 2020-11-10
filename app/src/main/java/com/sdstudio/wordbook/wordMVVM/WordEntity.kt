package com.sdstudio.wordbook.wordMVVM

import androidx.room.Entity
import androidx.room.PrimaryKey


data class WordEntity (var Word: String,var Mean: String, var expandable: Boolean = false)
