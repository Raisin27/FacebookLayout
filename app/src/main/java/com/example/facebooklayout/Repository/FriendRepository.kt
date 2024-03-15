package com.example.facebooklayout.Repository

import androidx.room.Query
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.Model.FriendDatabase

class FriendRepository(private val db: FriendDatabase) {

    suspend fun insertFriend(friend: Friend) = db.getFriendDAO().insertFriend(friend)

    suspend fun deleteFriend(friend: Friend) = db.getFriendDAO().deleteFriend(friend)

    suspend fun updateFriend(friend: Friend) = db.getFriendDAO().updateFriend(friend)

    fun getAllFriends() = db.getFriendDAO().getAllFriends()
    fun searchFriend(query: String?) = db.getFriendDAO().searchFriend(query)


}