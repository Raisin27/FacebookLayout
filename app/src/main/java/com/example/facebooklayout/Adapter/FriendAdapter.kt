package com.example.facebooklayout.Adapter

import android.content.DialogInterface.OnClickListener
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.R
import com.example.facebooklayout.databinding.FriendLayoutBinding
import com.example.facebooklayout.fragment.FriendsFragment
import com.example.facebooklayout.fragment.FriendsFragmentDirections
import java.util.Random

class FriendAdapter(val friendsList: List<Friend>
//, clickListener: (Friend) -> Unit
): RecyclerView.Adapter<FriendViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FriendViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: FriendLayoutBinding
        binding = DataBindingUtil.inflate(
            layoutInflater, R.layout.friend_layout, parent, false
        )

        return FriendViewHolder(binding)


    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {

        holder.bindTheView(friendsList[position])


    }

    override fun getItemCount(): Int {
        return friendsList.size
    }


}
class FriendViewHolder(val binding: FriendLayoutBinding):
    RecyclerView.ViewHolder(binding.root) {
    fun bindTheView(friend: Friend) {
        binding.txtfriendName.text = friend.friendName

        binding.listItemLayout.setOnClickListener { view ->
            val bundle = Bundle()

            bundle.putString("itemId",friend.id.toString())
            bundle.putString("name", friend.friendName)

            Log.d("itemId",friend.id.toString())
            Log.d("name",friend.friendName)


            Navigation.findNavController(view)
                .navigate(R.id.action_friendsFragment_to_updateFriendFragment, bundle)

        }
    }
}