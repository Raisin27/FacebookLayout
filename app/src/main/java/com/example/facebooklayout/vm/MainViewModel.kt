package com.example.facebooklayout.vm

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.facebooklayout.Model.UserDAO
import com.example.facebooklayout.Repository.MainRepository

class MainViewModel(val repository: MainRepository)
    : ViewModel(), Observable{
//    constructor(): this(MainRepository(userDAO))

    val detailItems  = repository.detailItems

    val userInfo  = repository.userInfo

    @Bindable
    var name = MutableLiveData<String?>()

    @Bindable
    var caption = MutableLiveData<String?>()

    @Bindable
    var avatar = MutableLiveData<Int>()



    @Bindable
    var bg = MutableLiveData<Int>()

    fun updateResourceId(resourceId: Int){
        avatar.value = resourceId
    }
    fun updateBgResourceId(resourceId: Int){
        bg.value = resourceId
    }
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}