package com.example.facebooklayout.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.facebooklayout.Model.DetailItem
import com.example.facebooklayout.R

class DetailAdapter(private val items: List<DetailItem>):
    RecyclerView.Adapter<DetailAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.title_txt)
        val itemImg: ImageView = itemView.findViewById(R.id.img_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int =
        items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImg.setImageResource(items[position].img)
        holder.itemTitle.setText(items[position].title)
    }

}