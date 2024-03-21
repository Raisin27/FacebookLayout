package com.example.facebooklayout.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.facebooklayout.Adapter.FriendAdapter
import com.example.facebooklayout.MainActivity
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.Model.FriendDAO
import com.example.facebooklayout.Model.FriendDatabase
import com.example.facebooklayout.Model.UserDatabase
import com.example.facebooklayout.R
import com.example.facebooklayout.Repository.FriendRepository
import com.example.facebooklayout.Repository.MainRepository
import com.example.facebooklayout.databinding.FragmentFriendsBinding
import com.example.facebooklayout.vm.FriendViewModel
import com.example.facebooklayout.vm.FriendViewModelFactory
import com.example.facebooklayout.vm.ViewModelFactory

class FriendsFragment : Fragment(R.layout.fragment_friends){

    lateinit var _binding: FragmentFriendsBinding

    private val binding get() = _binding

    private lateinit var friendsViewModel : FriendViewModel
    private lateinit var friendAdapter: FriendAdapter
    var dummyList = listOf<Friend>()
//    private val args: UpdateFriendFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_friends, container, false)

        val dao = FriendDatabase.getInstance(requireContext()).friendDAO()
        val repository = FriendRepository(dao)
        val factory = FriendViewModelFactory(repository)

        friendsViewModel = ViewModelProvider(this, factory)
            .get(FriendViewModel::class.java)
//        val clickListener: (Friend) -> Unit = { friend ->
//            // Handle click action here, for example, navigate to another fragment
//            val id = friend.id
//            val name = friend.friendName
//            val action =
//                FriendsFragmentDirections.actionFriendsFragmentToUpdateFriendFragment(id, name)
//
//            view?.findNavController()?.navigate(action)
//        }



        friendAdapter = FriendAdapter(dummyList)

        binding.rcvFriends.layoutManager = LinearLayoutManager(requireContext())

        friendsViewModel.friends.observe(viewLifecycleOwner, Observer {
            friendAdapter = FriendAdapter(it)
            binding.rcvFriends.adapter = friendAdapter
        })

        binding.btnAddFriend.setOnClickListener{
            it.findNavController().navigate(
                R.id.action_friendsFragment_to_newFriendFragment
            )
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)


    }



//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
}
