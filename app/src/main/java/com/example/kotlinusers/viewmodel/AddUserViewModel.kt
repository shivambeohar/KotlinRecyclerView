package com.example.kotlinusers.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.kotlinusers.model.repository.UserRepository
import com.example.kotlinusers.model.room.User
import com.example.kotlinusers.model.room.UserDatabase

class AddUserViewModel(application: Application) : AndroidViewModel(application){

    private var mApplication: Application = application
    var userRepository: UserRepository

    //Static variable
    companion object {
        private const val TAG: String = "AddUser"
    }

    init {
        val userDao = UserDatabase.getInstance(mApplication).userDao()
        userRepository = UserRepository(userDao)
    }

    /**
     * Insert the user data in User Table
     */
    fun insertUser(user: User) {
        userRepository.insertUser(user)
    }

    /**
     * Called when viewModel destroyed
     */
    override fun onCleared() {
        Log.d(TAG, "View Model Destroyed")
    }
}