package com.example.facebooklayout.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.facebooklayout.Adapter.FriendAdapter
import com.example.facebooklayout.MainActivity
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.R
import com.example.facebooklayout.databinding.FragmentFriendsBinding
import com.example.facebooklayout.databinding.FragmentNewFriendBinding
import com.example.facebooklayout.databinding.FragmentUpdateFriendBinding
import com.example.facebooklayout.vm.FriendViewModel


class UpdateFriendFragment : Fragment(R.layout.fragment_update_friend) {
    private var _binding : FragmentUpdateFriendBinding? = null
    private val binding get() = _binding!!

    private lateinit var friendsViewModel: FriendViewModel

    private lateinit var currentFriend: Friend


    private val args: UpdateFriendFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateFriendBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        friendsViewModel = (activity as MainActivity).friendViewModel
        currentFriend = args.friend!!

        binding.edFriendNameUpdate.setText(currentFriend.friendName)
        binding.edAvatarResourceUpdate.setText(currentFriend.friendImg)

        //if the user update the friend's name
        binding.fabDone.setOnClickListener{
            val name = binding.edFriendNameUpdate.text.toString().trim()
            val img = binding.edAvatarResourceUpdate.text.toString().trim()

            if(name.isNotEmpty()){
                val  friend = Friend(currentFriend.id, name, img)
                friendsViewModel.updateFriend(friend)
                view.findNavController().navigate(R.id.action_updateFriendFragment_to_friendsFragment)
            }
            else{
                Toast.makeText(
                    context,
                    "Please enter note Title",
                    Toast.LENGTH_LONG).show()
            }
        }

    }
    private fun deleteNote(){
        AlertDialog.Builder(activity).apply {
            setTitle("Delete Friend")
            setMessage("You want to delete this Friend?")
            setPositiveButton("Delete"){_,_ ->
                friendsViewModel.deleteFriend(currentFriend)
                view?.findNavController().navigate(
                    R.id.action_updateFriendFragment_to_friendsFragment
                )
            }

            setNegativeButton("Cancel", null)
        }.create().show()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
//        inflater.inflate(R.menu.memu_update_friend, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.menu_delete -> {
//                deleteFriend(mView)
//            }
//        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}