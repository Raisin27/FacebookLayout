package com.example.facebooklayout.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.facebooklayout.Model.Friend
import com.example.facebooklayout.databinding.FriendLayoutBinding
import com.example.facebooklayout.fragment.FriendsFragment
import com.example.facebooklayout.fragment.FriendsFragmentDirections
import java.util.Random

class FriendAdapter: RecyclerView.Adapter<FriendAdapter.FriendViewHolder>() {
    class FriendViewHolder(val itemBinding: FriendLayoutBinding):
    RecyclerView.ViewHolder(itemBinding.root){

    }
    private val differCallback = object : DiffUtil.ItemCallback<Friend>() {
        override fun areItemsTheSame(oldItem: Friend, newItem: Friend): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.friendName == newItem.friendName &&
                    oldItem.friendImg == newItem.friendImg
        }

        override fun areContentsTheSame(oldItem: Friend, newItem: Friend): Boolean {
            return oldItem == newItem
        }
    }

        val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FriendAdapter.FriendViewHolder {
        return FriendViewHolder(
            FriendLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent,false
        )
        )

    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        val currentFriend = differ.currentList[position]

//        holder.itemBinding. = currentFriend.friendImg
        holder.itemBinding.txtFriendName.text = currentFriend.friendName

//        val random = Random()
//
//        val color = Color.argb(
//            255,
//            random.nextInt(256),
//            random.nextInt(256),
//            random.nextInt(256)
//        )
//        holder.itemBinding.ibColor.setBackgroundColor(color)


        holder.itemView.setOnClickListener {
            val direction = FriendsFragmentDirections
                .actionFriendsFragmentToUpdateFriendFragment(currentFriend)

            it.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}