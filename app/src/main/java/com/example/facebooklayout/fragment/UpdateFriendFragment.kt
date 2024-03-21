package com.example.facebooklayout.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.facebooklayout.Adapter.FriendAdapter
import com.example.facebooklayout.MainActivity
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.Model.FriendDatabase
import com.example.facebooklayout.R
import com.example.facebooklayout.Repository.FriendRepository
import com.example.facebooklayout.databinding.FragmentUpdateFriendBinding
//import com.example.facebooklayout.fragment.UpdateFriendFragmentArgs
import com.example.facebooklayout.vm.FriendViewModel
import com.example.facebooklayout.vm.FriendViewModelFactory


class UpdateFriendFragment : Fragment(R.layout.fragment_update_friend) {
    private lateinit var binding: FragmentUpdateFriendBinding
//    private val binding get() = _binding!!

    private lateinit var friendsViewModel: FriendViewModel
    lateinit var name: String
    lateinit var id: String


    //    private val args: UpdateFriendFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUpdateFriendBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dao = FriendDatabase.getInstance(requireContext()).friendDAO()
        val repository = FriendRepository(dao)
        val factory = FriendViewModelFactory(repository)

        friendsViewModel = ViewModelProvider(this, factory).get(FriendViewModel::class.java)

//        id = args.itemId.toString()
//        Log.d("idGet", id)
//
//        name = args.name
//        Log.d("nameGet", name)
        id = requireArguments().getString("itemId").toString()
        name = requireArguments().getString("name").toString()
        Log.d(id, id)
        Log.d(name, name)


        binding.edFriendNameUpdate.setText(name)

        //if the user update the friend's name
        binding.btnDone.setOnClickListener {
            Log.d("DONE", id + name)

            val newid = id.toIntOrNull() ?: 0
            val newname = binding.edFriendNameUpdate.text
            Log.d("newname", newname.toString())

            friendsViewModel.editFriend(Friend(newid, newname.toString()))

            Toast.makeText(context, "UPDATED", Toast.LENGTH_SHORT).show()
            view.findNavController().navigate(R.id.action_updateFriendFragment_to_friendsFragment)
        }

    }

//    private fun deleteNote(){
//        AlertDialog.Builder(activity).apply {
//            setTitle("Delete Friend")
//            setMessage("You want to delete this Friend?")
//            setPositiveButton("Delete"){_,_ ->
//                friendsViewModel.deleteFriend(currentFriend)
//                view?.findNavController()?.navigate(
//                    R.id.action_updateFriendFragment_to_friendsFragment
//                )
//            }
//
//            setNegativeButton("Cancel", null)
//        }.create().show()
//
//    }

    //    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        menu.clear()
////        inflater.inflate(R.menu.memu_update_friend, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
////        when(item.itemId){
////            R.id.menu_delete -> {
////                deleteFriend(mView)
////            }
////        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
}
//
//}