package com.example.facebooklayout.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "friends")
@Parcelize
data class Friend(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val friendName : String,
    val friendImg : Int
):Parcelable
