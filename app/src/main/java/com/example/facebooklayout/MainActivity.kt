package com.example.facebooklayout
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Display
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.facebooklayout.Adapter.FriendAdapter
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.Model.FriendDAO
import com.example.facebooklayout.Model.FriendDatabase
import com.example.facebooklayout.Model.UserDatabase
import com.example.facebooklayout.Repository.FriendRepository
import com.example.facebooklayout.Repository.MainRepository
import com.example.facebooklayout.databinding.ActivityMainBinding
import com.example.facebooklayout.fragment.FriendsFragment
import com.example.facebooklayout.fragment.PhotoFragment
import com.example.facebooklayout.fragment.PostFragment
import com.example.facebooklayout.fragment.ReelFragment
import com.example.facebooklayout.vm.FriendViewModel
import com.example.facebooklayout.vm.FriendViewModelFactory
import com.example.facebooklayout.vm.MainViewModel
import com.example.facebooklayout.vm.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private lateinit var mainViewModel: MainViewModel

//    lateinit var friendViewModel : FriendViewModel


    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        //ROOM Database
//        val dao = UserDatabase.getInstance(applicationContext).userDAO
//        val repository = MainRepository(dao)
//        val factory = ViewModelFactory(repository)
//
//        setUpFriendViewModel()


//        viewmodel
//        mainViewModel = ViewModelProvider(this, factory)
//            .get(MainViewModel::class.java)
//
//        binding.detailData = mainViewModel
//
//        binding.lifecycleOwner = this


        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

//        avatar = findViewById(R.id.avatar)
//        username = findViewById(R.id.userName2)
//        bgImage = findViewById(R.id.backgroundImage)


//        // SharedPreferences에서 name 값을 불러와서 TextView에 설정
        val name = sharedPreferences.getString("name", "Mark")
//
        binding.userName2.text = name
        binding.userName1.text = name

        binding.avatar.setOnClickListener {
            val explicitIntent = Intent(this, AvatarActivity::class.java)
            // Lấy tên người dùng từ TextView
            val userNameString = binding.userName2.text.toString()
            explicitIntent.putExtra("username", userNameString)
            explicitIntent.putExtra("imgsrc", R.drawable.markzuckerbergavatar)
            startActivity(explicitIntent)
        }
        binding.backgroundImage.setOnClickListener {
            val explicitIntent = Intent(this, BackgroundActivity::class.java)
            // Lấy tên người dùng từ TextView
            val userNameString = binding.userName2.text.toString()
            explicitIntent.putExtra("username", userNameString)
            explicitIntent.putExtra("imgsrc", R.drawable.earth)
            startActivity(explicitIntent)
        }
//        val followBtn : Button = findViewById(R.id.followButton)
//        val chatBtn : Button = findViewById(R.id.chatButton)
//        val moreBtn : Button = findViewById(R.id.moreButton)
//        val postBtn : Button = findViewById(R.id.postsBtn)
//        val photoBtn : Button = findViewById(R.id.photosBtn)
//        val reelBtn : Button = findViewById(R.id.reelsBtn)
//        val friendsBtn : Button = findViewById(R.id.friendsBtn)
        binding.followButton.setOnClickListener {
            val followBtn = it as Button
            if (followBtn.isActivated) {
                followBtn.isActivated = false
                followBtn.text = "Following"
            } else {
                followBtn.isActivated = true
                followBtn.text = "Followed"
            }
        }
        binding.chatButton.setOnClickListener {
            Toast.makeText(
                this,
                "Messenger page...",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.moreButton.setOnClickListener {
            val intent = Intent(this, SettingActivity::class.java)
            // Lấy tên người dùng từ TextView
            val userNameString = binding.userName2.text.toString()
            intent.putExtra("username", userNameString)
            startActivity(intent)
        }
        binding.postsBtn.setOnClickListener {
            binding.postsBtn.isActivated = true
            // Đặt các Button còn lại về trạng thái không được kích hoạt
            binding.photosBtn.isActivated = false
            binding.reelsBtn.isActivated = false
            val postFragment: PostFragment = PostFragment()
            loadFragment(postFragment)
        }
        binding.photosBtn.setOnClickListener {
            binding.photosBtn.isActivated = true
            // Đặt các Button còn lại về trạng thái không được kích hoạt
            binding.postsBtn.isActivated = false
            binding.reelsBtn.isActivated = false
            val photoFragment: PhotoFragment = PhotoFragment()
            loadFragment(photoFragment)
        }
        binding.reelsBtn.setOnClickListener {
            binding.postsBtn.isActivated = false
            binding.photosBtn.isActivated = false
            binding.reelsBtn.isActivated = true
            binding.friendsBtn.isActivated = false
            loadFragment(ReelFragment())
        }
        binding.friendsBtn.setOnClickListener {
            binding.postsBtn.isActivated = false
            binding.photosBtn.isActivated = false
            binding.reelsBtn.isActivated = false
            binding.friendsBtn.isActivated = true
            loadFragment(FriendsFragment())

            // userName2를 클릭하고 새로운 값을 입력하면 그 값이 변경되도록 코드를 추가합니다.
            binding.userName2.setOnClickListener {
                val dialog = AlertDialog.Builder(this)
                val editText = EditText(this)
                dialog.setView(editText)
                dialog.setPositiveButton("OK") { _, _ ->
                    val newName = editText.text.toString()
                    binding.userName2.text = newName
                    // 새로운 이름을 SharedPreferences에 저장합니다.
                    sharedPreferences.edit().putString("name", newName).apply()
                }
                dialog.setNegativeButton("Cancel") { dialogInterface, _ ->
                    dialogInterface.dismiss()
                }
                dialog.show()
            }
        }
    }

//    private fun setUpFriendViewModel() {
//        val dao = FriendDatabase.getInstance(applicationContext).friendDAO()
//        val repository = FriendRepository(dao)
//        val factory = FriendViewModelFactory(repository)
//
//
//        friendViewModel = ViewModelProvider(
//            this, factory)
//            .get(FriendViewModel::class.java)
//
//        binding.friendData = friendViewModel
//        binding.lifecycleOwner = this
//
//    }



    private fun loadFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction =
            fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}