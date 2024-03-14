package com.example.facebooklayout.ViewModel

import androidx.lifecycle.ViewModel
import com.example.facebooklayout.Repository.MainRepository

class MainViewModel(val repository: MainRepository): ViewModel(){
    constructor(): this(MainRepository())

    fun loadData() = repository.detailItems
    fun loadInfo() = repository.userInfo

}