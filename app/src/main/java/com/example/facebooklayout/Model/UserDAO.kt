package com.example.facebooklayout.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
@Dao
interface UserDAO {
    @Query("SELECT * FROM users_table")
    fun getAllUserInfo():LiveData<List<User>>
}