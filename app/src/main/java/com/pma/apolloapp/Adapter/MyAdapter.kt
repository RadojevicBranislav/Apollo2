package com.pma.apolloapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pma.apolloapp.Models.User
import com.pma.apolloapp.R
import com.squareup.picasso.Picasso

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

   private val userList = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_rcv,
            parent, false
        )

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = userList[position]

        holder.type.text = currentItem.type

        holder.name.text = currentItem.name

        Picasso.get().load(currentItem.image).into(holder.image)

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun updateUserList(userList: List<User>)
    {
        this.userList.clear()

        this.userList.addAll(userList)

        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val image: ImageView = itemView.findViewById(R.id.image_whiskey)

        val type: TextView = itemView.findViewById(R.id.type)

        val name: TextView = itemView.findViewById(R.id.whiskey_name)

    }

}