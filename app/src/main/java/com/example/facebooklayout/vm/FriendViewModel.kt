package com.example.facebooklayout.vm

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.Repository.FriendRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FriendViewModel(
    private val friendRepository: FriendRepository
):ViewModel(), Observable {
    @Bindable
    val friendName = MutableLiveData<String?>()

    fun insertFriend(friend: Friend) = viewModelScope.launch {
        Dispatchers.IO
        friendRepository.insertFriend(friend)
    }
//    fun deleteFriend(friend: Friend) =
//        viewModelScope.launch {
//            friendRepository.deleteFriend(friend)
//        }
    fun editFriend(friend: Friend){
        updateFriend(friend)
    }
    fun updateFriend(friend: Friend) =
        viewModelScope.launch {
            Dispatchers.IO
            friendRepository.updateFriend(friend)
        }

    val friends = friendRepository.friends
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

//    fun searchFriend(query: String?)
//    = friendRepository.searchFriend(query)
}