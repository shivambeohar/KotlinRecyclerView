package com.example.kotlinusers.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinusers.R
import com.example.kotlinusers.model.room.User
import kotlinx.android.synthetic.main.item_layout.view.*

class UserRecyclerViewAdapter(var userList: List<User>): RecyclerView.Adapter<UserRecyclerViewAdapter.UserDetailViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDetailViewHolder {
        var itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return UserDetailViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserDetailViewHolder, position: Int) {
        holder.username.text = userList[position].userName
        holder.email.text = userList[position].email
        holder.contact.text = userList[position].contact
    }

    inner class UserDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val username = itemView.tv_username
        val email = itemView.tv_email
        val contact = itemView.tv_contact
    }
}