package com.example.facebooklayout.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.Repository.FriendRepository
import kotlinx.coroutines.launch

class FriendViewModel(
    private val friendRepository: FriendRepository
):ViewModel() {
    fun addFriend(friend: Friend) =
        viewModelScope.launch {
            friendRepository.insertFriend(friend)
        }

    fun deleteFriend(friend: Friend) =
        viewModelScope.launch {
            friendRepository.deleteFriend(friend)
        }

    fun updateFriend(friend: Friend) =
        viewModelScope.launch {
            friendRepository.updateFriend(friend)
        }

    fun getAllFriends() = friendRepository.getAllFriends()

    fun searchFriend(query: String?)
    = friendRepository.searchFriend(query)
}