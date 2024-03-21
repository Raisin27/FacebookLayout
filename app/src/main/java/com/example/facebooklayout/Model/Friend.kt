package com.example.facebooklayout.Model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "friends_table")
@Parcelize
data class Friend(
//    @ColumnInfo("friendid")
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val friendName : String,

//    @ColumnInfo("friendname")
//    @PrimaryKey(autoGenerate = true)
////    val id: Int,
////    val friendName : String,
):Parcelable
