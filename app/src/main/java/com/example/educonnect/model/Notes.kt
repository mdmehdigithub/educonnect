package com.example.educonnect.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
@Entity
data class Notes(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String,
    val title: String,
    val note: String,
)