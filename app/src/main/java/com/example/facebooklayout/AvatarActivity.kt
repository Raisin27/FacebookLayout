package com.example.facebooklayout

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AvatarActivity : AppCompatActivity(){
    lateinit var userName : TextView
    lateinit var useAvatar : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.avatar_layout)

        userName = findViewById(R.id.avatarName)
        useAvatar = findViewById(R.id.avatarImg)

        //Receive data from Intent
        val receiveData = intent.getStringExtra("username")
        val receiveData2 = intent.getIntExtra("imgsrc", 0)

        //using received data
        userName.text = receiveData
        useAvatar.setImageResource(receiveData2)

        val likeBtn = findViewById<Button>(R.id.likeBtn)
        val cmtBtn = findViewById<Button>(R.id.cmtBtn)
        val shareBtn= findViewById<Button>(R.id.shareBtn)

        likeBtn.setOnClickListener{
            if(likeBtn.isActivated){
                likeBtn.isActivated = false
                likeBtn.text = "Like"
            }
            else{
                likeBtn.isActivated = true

                // Đặt các Button còn lại về trạng thái không được kích hoạt
                cmtBtn.isActivated = false
                shareBtn.isActivated = false

                likeBtn.text = "Liked"
            }

        }
        cmtBtn.setOnClickListener{
            Toast.makeText(
                this,
                "Comment...",
                Toast.LENGTH_SHORT
            ).show()
        }
        shareBtn.setOnClickListener{
            Toast.makeText(
                this,
                "Share...",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}