package com.pma.apolloapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pma.apolloapp.Models.User
import com.pma.apolloapp.R

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

   private val userList = ArrayList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_astronaut,
            parent, false
        )

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = userList[position]

        holder.craft.text = currentItem.craft
        holder.name.text = currentItem.name

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

        val craft: TextView = itemView.findViewById(R.id.astronaut_craft)
        val name: TextView = itemView.findViewById(R.id.astronaut)

    }

}