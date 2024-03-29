package com.twinrock.mymvvm.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.twinrock.mymvvm.data.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE email = :email")
    fun getUserByEmail(email: String): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers() : LiveData<List<User>>

}