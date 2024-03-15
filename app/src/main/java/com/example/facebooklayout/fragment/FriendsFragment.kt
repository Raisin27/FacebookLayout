package com.example.facebooklayout.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.facebooklayout.Adapter.FriendAdapter
import com.example.facebooklayout.MainActivity
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.R
import com.example.facebooklayout.databinding.FragmentFriendsBinding
import com.example.facebooklayout.vm.FriendViewModel

class FriendsFragment : Fragment(R.layout.fragment_friends) , SearchView.OnQueryTextListener{

    private var _binding: FragmentFriendsBinding? = null
    private val binding get() = _binding!!

    private lateinit var friendsViewModel : FriendViewModel
    private lateinit var friendAdapter: FriendAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFriendsBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsViewModel = (activity as MainActivity).friendViewModel

        setUpRecyclerView()
        binding.btnAddFriend.setOnClickListener{
            it.findNavController().navigate(
                R.id.action_friendsFragment_to_newFriendFragment
            )
        }


    }

    private fun setUpRecyclerView() {
        friendAdapter = FriendAdapter()

        binding.rcvFriends.apply{
            layoutManager = LinearLayoutManager(
                requireContext()
            )
            adapter = friendAdapter
        }
        activity?.let {
            friendsViewModel.getAllFriends().observe(
                viewLifecycleOwner,{
                    friend-> friendAdapter.differ.submitList(friend)
                    updateUI(friend)
                }
            )
        }

    }

    private fun updateUI(friend: List<Friend>?){
        if(friend!= null && friend.isNotEmpty()){
            binding.cardView.visibility = View.GONE
            binding.rcvFriends.visibility = View.VISIBLE
        }
        else{
            binding.cardView.visibility = View.VISIBLE
            binding.rcvFriends.visibility = View.GONE
        }

    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        menu.clear()
//        inflater.inflate(R.menu.home_menu, menu)...

//    val mMenuSearch = menu.findItem(R.id.menu_search).actionView as
//    }

    override fun onQueryTextSubmit(query: String?): Boolean {
//        searchFriend(query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
//        if(newText != null){
//            searchFriend(newText)
//        }
        return true
    }
//    private fun searchFriend(query:String?){
//        val searchQuery = "%$query"
//        friendsViewModel.searchFriend(query)
//
//    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}
