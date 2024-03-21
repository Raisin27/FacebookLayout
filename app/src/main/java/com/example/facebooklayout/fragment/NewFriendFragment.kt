package com.example.facebooklayout.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.facebooklayout.Adapter.FriendAdapter
import com.example.facebooklayout.MainActivity
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.Model.FriendDatabase
import com.example.facebooklayout.R
import com.example.facebooklayout.Repository.FriendRepository
import com.example.facebooklayout.databinding.FragmentNewFriendBinding
import com.example.facebooklayout.vm.FriendViewModel
import com.example.facebooklayout.vm.FriendViewModelFactory


class NewFriendFragment : Fragment(R.layout.fragment_new_friend) {
    lateinit var binding : FragmentNewFriendBinding

    lateinit var friendsViewModel: FriendViewModel
//    lateinit var friendAdapter: FriendAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_friend, container, false)

        val dao = FriendDatabase.getInstance(requireContext()).friendDAO()
        val repository = FriendRepository(dao)
        val factory = FriendViewModelFactory(repository)

        friendsViewModel = ViewModelProvider(this, factory).get(FriendViewModel::class.java)

        binding.friendViewModel = friendsViewModel
        binding.lifecycleOwner = this

        binding.btnSaveFriend.setOnClickListener{
            val name = binding.edFriendName.text
            Log.d("INSERT", name.toString())

            friendsViewModel.insertFriend(Friend(0, name.toString()))
            view?.findNavController()?.navigate(R.id.action_newFriendFragment_to_friendsFragment)
            Toast.makeText(context, "FRIEND SAVED", Toast.LENGTH_SHORT).show()

        }


        return binding.root
    }





}