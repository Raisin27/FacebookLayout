package com.example.facebooklayout.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val name: String,
    val caption: String,
    val avatar: Int,
    val bgImg: Int,
)