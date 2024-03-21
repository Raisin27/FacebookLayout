package com.example.facebooklayout.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.facebooklayout.Repository.FriendRepository

class FriendViewModelFactory(private val friendRepository: FriendRepository)
    :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FriendViewModel::class.java)){
            return FriendViewModel(friendRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}