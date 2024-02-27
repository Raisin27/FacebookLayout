package com.example.facebooklayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val itemsList:ArrayList<ItemModel>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImg:ImageView
        var itemTitle:TextView

        init{
            itemImg = itemView.findViewById(R.id.img_icon)
            itemTitle = itemView.findViewById(R.id.title_txt)

            itemView.setOnClickListener(){
                Toast.makeText(
                    itemView.context,
                    itemsList[adapterPosition].title,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemImg.setImageResource(itemsList[position].img)
        holder.itemTitle.setText(itemsList[position].title)
    }

}