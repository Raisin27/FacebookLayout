package com.example.facebooklayout.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.facebooklayout.Adapter.FriendAdapter
import com.example.facebooklayout.MainActivity
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.R
import com.example.facebooklayout.databinding.FragmentNewFriendBinding
import com.example.facebooklayout.vm.FriendViewModel



class NewFriendFragment : Fragment(R.layout.fragment_new_friend) {
    private var _binding : FragmentNewFriendBinding? = null
    private val binding get() = _binding!!

    private lateinit var friendsViewModel: FriendViewModel
    private lateinit var friendAdapter: FriendAdapter

    private lateinit var mView: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewFriendBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsViewModel = (activity as MainActivity).friendViewModel

        mView = view


    }
    private fun saveFriend(view: View){
        val friendName = binding.edFriendName.text.toString().trim()
        val friendImg = binding.edAvatarResource

        if(friendName.isNotEmpty()){
            val friend = Friend(0,friendName, 1)
            friendsViewModel.addFriend(friend)

            Toast.makeText(mView.context,
                "Friend saved Successfully",
                Toast.LENGTH_LONG).show()

            view.findNavController().navigate(R.id.action_newFriendFragment_to_friendsFragment)
        }

        else {
            Toast.makeText(
                mView.context,
                "Please enter Friend's name",
                Toast.LENGTH_LONG
            ).show()
        }



    }
    //        super.onCreateOptionsMenu(menu, inflater)
//        menu.clear()
//        inflater.inflate(R.menu.home_menu, menu)...

//    val mMenuSearch = menu.findItem(R.id.menu_search).actionView as
//    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.menu_save -> {
//                saveFriend(mView)
//            }
//        }
        return super.onOptionsItemSelected(item)
    }





}