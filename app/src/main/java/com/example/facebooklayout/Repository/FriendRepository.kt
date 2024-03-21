package com.example.facebooklayout.Repository

import androidx.room.Query
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.Model.FriendDAO
import com.example.facebooklayout.Model.FriendDatabase

class FriendRepository(private val dao: FriendDAO) {

    suspend fun insertFriend(friend: Friend) = dao.insertFriend(friend)

    suspend fun deleteFriend(friend: Friend) = dao.deleteFriend(friend)

    suspend fun updateFriend(friend: Friend) = dao.updateFriend(friend)

    val friends = dao.getAllFriends()
//    fun searchFriend(query: String?) = dao.searchFriend(query)


}