package com.example.roompractice

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    val name: String?,
    val age: String?,
    val phoneNumber: String?,
)