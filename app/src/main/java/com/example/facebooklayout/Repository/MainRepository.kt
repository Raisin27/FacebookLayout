package com.example.facebooklayout.Repository

import com.example.facebooklayout.Model.DetailItem
import com.example.facebooklayout.Model.User
import com.example.facebooklayout.Model.UserDAO
import com.example.facebooklayout.R

class MainRepository(private val userDAO: UserDAO) {
    val detailItems : MutableList<DetailItem> = mutableListOf(
        DetailItem("Founder and CEO ", R.drawable.bag),
        DetailItem("Works at Chan Zuckerberg Initiative", R.drawable.bag),
        DetailItem("Studied Computer Science and Psychology at Harvard University", R.drawable.graduation),
        DetailItem("Lives in Palo Alto, California", R.drawable.home),
        DetailItem("From Dobbs Ferry, New York", R.drawable.location),
    )

    val userInfo : MutableList<User> = mutableListOf(
//        userDAO.getAllUserInfo()
        User(1, "Mark","Begin a new road", R.drawable.markzuckerbergavatar, R.drawable.background)
    )
}