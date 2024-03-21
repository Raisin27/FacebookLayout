package com.example.facebooklayout.Model

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface FriendDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFriend(friend: Friend)

    @Update
    suspend fun updateFriend(friend: Friend)

    @Delete
    suspend fun deleteFriend(friend: Friend)

    @Query("SELECT * FROM friends_table")
    fun getAllFriends(): LiveData<List<Friend>>

//    @Query("SELECT * FROM friends WHERE friendName LIKE :query")
//    fun searchFriend(query: String?): LiveData<List<Friend>>
}