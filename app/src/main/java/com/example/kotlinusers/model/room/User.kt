package com.example.kotlinusers.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "contact") val contact: String
){
    constructor(userName: String,
                email: String,
                contact: String):this(0,userName,email,contact)
}