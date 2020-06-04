package com.example.kotlinusers.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlinusers.model.repository.UserRepository
import com.example.kotlinusers.model.room.User
import com.example.kotlinusers.model.room.UserDatabase

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var mApplication: Application = application
    private var userRepository: UserRepository

    //Static variable
    companion object {
        private const val TAG: String = "UserViewModel"
    }

    init {
        val userDao = UserDatabase.getInstance(mApplication).userDao()
        userRepository = UserRepository(userDao)
    }

    /**
     * Fetch all the users from the user Table
     */
    fun getAllUsers(): LiveData<List<User>>? {
        return userRepository.getAllUsers()
    }

    /**
     * Called when viewModel destroyed
     */
    override fun onCleared() {
        Log.d(TAG, "View Model Destroyed")
    }
}