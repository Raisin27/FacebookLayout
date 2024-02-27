package com.example.facebooklayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class BackgroundActivity : AppCompatActivity() {

    lateinit var bgImg : ImageView
    lateinit var bgName : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)

        bgImg = findViewById(R.id.bgImg)
        bgName = findViewById(R.id.bgName)

        val receiveData = intent.getStringExtra("username")
        val receiveData2 = intent.getIntExtra("imgsrc", 0)

        //using received data
        bgName.text = "$receiveData of background"
        bgImg.setImageResource(receiveData2)

        val likeBtn = findViewById<Button>(R.id.likeBtn)
        val cmtBtn = findViewById<Button>(R.id.cmtBtn)
        val shareBtn= findViewById<Button>(R.id.shareBtn)

        likeBtn.setOnClickListener{
            if(likeBtn.isActivated){
                likeBtn.isActivated = false
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