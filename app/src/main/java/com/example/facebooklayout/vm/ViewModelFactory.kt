package com.example.facebooklayout.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.facebooklayout.Repository.MainRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: MainRepository)
    :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")

    }
    }
