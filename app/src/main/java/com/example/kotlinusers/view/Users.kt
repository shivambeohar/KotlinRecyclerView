package com.example.kotlinusers.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinusers.R
import com.example.kotlinusers.adapters.UserRecyclerViewAdapter
import com.example.kotlinusers.model.room.User
import com.example.kotlinusers.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_users.*

class Users : AppCompatActivity() {

    private var mUserDetailRecyclerViewAdapter: UserRecyclerViewAdapter? = null
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        userViewModel = ViewModelProviders.of(this).get(UserViewModel(application)::class.java)

        userViewModel.getAllUsers()?.observe(this, Observer<List<User>> {
                users: List<User> -> println("##### $users #####")
            mUserDetailRecyclerViewAdapter = UserRecyclerViewAdapter(users)
            recycler_view.layoutManager = LinearLayoutManager(this@Users)
            recycler_view.adapter = mUserDetailRecyclerViewAdapter
        })
    }
}
