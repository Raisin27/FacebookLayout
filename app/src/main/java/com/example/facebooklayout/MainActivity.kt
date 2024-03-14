package com.example.facebooklayout
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.facebooklayout.Adapter.DetailAdapter
import com.example.facebooklayout.ViewModel.MainViewModel
import com.example.facebooklayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var avatar : ImageView
    lateinit var username : TextView
    lateinit var bgImage : ImageView
    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val detailAdapter by lazy { DetailAdapter(mainViewModel.loadData()) }

                {

                }

        }

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        avatar = findViewById(R.id.avatar)
        username = findViewById(R.id.userName2)
        bgImage = findViewById(R.id.backgroundImage)

        // SharedPreferences에서 name 값을 불러와서 TextView에 설정
        val name = sharedPreferences.getString("name", "Mark")

        username.text = name
        avatar.setOnClickListener{
            val explicitIntent = Intent(this, AvatarActivity::class.java)
            // Lấy tên người dùng từ TextView
            val userNameString = username.text.toString()
            explicitIntent.putExtra("username",userNameString)
            explicitIntent.putExtra("imgsrc",R.drawable.markzuckerbergavatar)
            startActivity(explicitIntent)
        }
        bgImage.setOnClickListener{
            val explicitIntent = Intent(this, BackgroundActivity::class.java)
            // Lấy tên người dùng từ TextView
            val userNameString = username.text.toString()
            explicitIntent.putExtra("username",userNameString)
            explicitIntent.putExtra("imgsrc",R.drawable.earth)
            startActivity(explicitIntent)
        }
        val followBtn : Button = findViewById(R.id.followButton)
        val chatBtn : Button = findViewById(R.id.chatButton)
        val moreBtn : Button = findViewById(R.id.moreButton)
        val postBtn : Button = findViewById(R.id.postsBtn)
        val photoBtn : Button = findViewById(R.id.photosBtn)
        val reelBtn : Button = findViewById(R.id.reelsBtn)
        followBtn.setOnClickListener{
            if(followBtn.isActivated){
                followBtn.isActivated = false
                followBtn.text = "Following"
            }
            else{
                followBtn.isActivated = true
                followBtn.text = "Followed"
            }
        }
        chatBtn.setOnClickListener{
            Toast.makeText(
                this,
                "Messenger page...",
                Toast.LENGTH_SHORT
            ).show()
        }
        moreBtn.setOnClickListener{
            val intent = Intent(this, SettingActivity::class.java)
            // Lấy tên người dùng từ TextView
            val userNameString = username.text.toString()
            intent.putExtra("username",userNameString)
            startActivity(intent)
        }
        postBtn.setOnClickListener{
            postBtn.isActivated = true
            // Đặt các Button còn lại về trạng thái không được kích hoạt
            photoBtn.isActivated = false
            reelBtn.isActivated = false
            val postFragment : PostFragment = PostFragment()
            loadFragment(postFragment)
        }
        photoBtn.setOnClickListener{
            photoBtn.isActivated = true
            // Đặt các Button còn lại về trạng thái không được kích hoạt
            postBtn.isActivated = false
            reelBtn.isActivated = false
            val photoFragment : PhotoFragment = PhotoFragment()
            loadFragment(photoFragment)
        }
        reelBtn.setOnClickListener{
            reelBtn.isActivated = true
            // Đặt các Button còn lại về trạng thái không được kích hoạt
            photoBtn.isActivated = false
            postBtn.isActivated = false
            val reelFragment : ReelFragment = ReelFragment()
            loadFragment(reelFragment)
        }
        // userName2를 클릭하고 새로운 값을 입력하면 그 값이 변경되도록 코드를 추가합니다.
        username.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            val editText = EditText(this)
            dialog.setView(editText)
            dialog.setPositiveButton("OK") { _, _ ->
                val newName = editText.text.toString()
                username.text = newName
                // 새로운 이름을 SharedPreferences에 저장합니다.
                sharedPreferences.edit().putString("name", newName).apply()
            }
            dialog.setNegativeButton("Cancel") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            dialog.show()
        }
    }
    fun loadFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction =
        fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.framelayout, fragment)
        fragmentTransaction.commit()
    }
}