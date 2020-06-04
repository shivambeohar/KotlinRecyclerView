package com.example.kotlinusers.model.repository

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.kotlinusers.model.room.User
import com.example.kotlinusers.model.room.UserDao

class UserRepository(private val userDao: UserDao) {

    companion object {
        private const val TAG: String = "UserRepository"
    }


    fun insertUser(user: User) {
        InsertAsyncTask(user, userDao).execute()
        Log.d(TAG,"$user added")
        Log.d(TAG, "$userDao")
    }

    fun getAllUsers(): LiveData<List<User>>? {
        return userDao.getAllUser()
    }

    class InsertAsyncTask(private val user: User, private var userDao: UserDao) :
        AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            userDao.insertUser(user)
            Log.d(TAG,"Adding $user Asynchronously")
            Log.d(TAG, "$userDao")
        }
    }
}