package com.example.kotlinusers.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    //dao methods for each entity
    abstract fun userDao(): UserDao


    companion object {

        private val userDatabaseInstance: UserDatabase? = null

        //create singleton instance of database
        fun getInstance(context: Context): UserDatabase {
            synchronized(this) {
                return userDatabaseInstance ?: Room.databaseBuilder(
                    context,
                    UserDatabase::class.java,
                    "users"
                ).build()
            }
        }
    }
}