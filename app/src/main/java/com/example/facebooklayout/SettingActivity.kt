package com.example.facebooklayout

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
class SettingActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var block : TextView
    lateinit var tv_helpUser : TextView
    lateinit var tv_ProfileLink : TextView
    lateinit var tv_Subtitle : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        tv_helpUser = findViewById(R.id.tv_HelpUser)
        tv_ProfileLink = findViewById(R.id.tv_ProfileLink)
        tv_Subtitle = findViewById(R.id.tv_Subtitle)

        //Receive data from Intent
        val receivedUsername = intent.getStringExtra("username")
        tv_helpUser.text = "Help $receivedUsername"
        tv_ProfileLink.text = "$receivedUsername's Profile Link"
        tv_Subtitle.text = "$receivedUsername's personalized link on Facebook"

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        block = findViewById(R.id.tv_Block)

        // SharedPreferences에서 name 값을 불러와서 AlertDialog의 제목에 설정
        val name = sharedPreferences.getString("name", "")
        val isBlock = sharedPreferences.getString("isBlock", "Block")
        block.text = isBlock
        Log.d("Block status", "$isBlock")
        block.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Block $name?💁‍♀️ ")
            builder.setMessage(
                "Name will no longer be able to:\n" +
                        "ㆍsee your post\n" +
                        "ㆍtag you\n" +
                        "ㆍInvite you to events or groups\n" +
                        "ㆍStart a conversation with you\n" +
                        "ㆍAdd you as a friend\n" +
                        "ㆍIf your're friends, blocking $name\n" +
                        "ㆍwill also unfriend $name"
            )
            builder.setPositiveButton("$isBlock") { dialogInterface: DialogInterface, _: Int ->
                if(block.text == "Block"){
                    block.text = "Unblock"
                }else{
                    block.text = "Block"
                }
                val newStatus = block.text.toString()
                sharedPreferences.edit().putString("isBlock", newStatus).apply()
//                Toast.makeText(
//                    this,
//                    "Blocked",
//                    Toast.LENGTH_SHORT
//                ).show()
                dialogInterface.dismiss()
            }
            builder.setNegativeButton("Cancel") { dialogInterface: DialogInterface, _: Int ->
                dialogInterface.dismiss()
            }
            builder.show()
//            // Tạo AlertDialog từ builder
//            val dialog = builder.create()
//            // Hiển thị AlertDialog
//            dialog.show()

//            if(dialog.getButton(AlertDialog.BUTTON_POSITIVE).text == "Unblock"){
//                dialog.getButton(AlertDialog.BUTTON_POSITIVE).text = "Block"
//            }else{
//                dialog.getButton(AlertDialog.BUTTON_POSITIVE).text = "Unblock"
//            }

        }
    }
}