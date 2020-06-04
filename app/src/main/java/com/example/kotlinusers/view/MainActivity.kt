package com.example.kotlinusers.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinusers.R
import com.example.kotlinusers.databinding.ActivityMainBinding
import com.example.kotlinusers.model.room.User
import com.example.kotlinusers.viewmodel.AddUserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mMainActivityDataBinding: ActivityMainBinding
    private lateinit var mAddUserViewModel: AddUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainActivityDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mAddUserViewModel = ViewModelProviders.of(this).get(AddUserViewModel(application)::class.java)

        btn_save.setOnClickListener {  mAddUserViewModel.insertUser(
            User(edt_username.text.toString(), edt_user_email.text.toString(),
            edt_user_contact.text.toString())
        ) }

        mAddUserViewModel.userRepository.getAllUsers()?.observe(this, Observer {users->
           tv_total_users.text = users.size.toString()
        })

        btn_user_list.setOnClickListener { startActivity(Intent(this@MainActivity,Users::class.java)) }
    }
}
