package com.example.roompractice

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update

/**
 * Data Access Object
 */
@Dao
interface UserDAO {
    @Insert(onConflict = REPLACE)
    fun setInsertUser(user: User)

    @Update
    fun setUpdateUser(user: User)

    @Delete
    fun setDeleteUser(user: User)

    @Query("SELECT * FROM user")
    fun getUserAll(): List<User>
}