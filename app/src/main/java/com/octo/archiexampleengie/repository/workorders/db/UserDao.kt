package com.octo.archiexampleengie.repository.workorders.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM userdb")
    fun getAll(): List<UserDb>

    @Query("SELECT * FROM userdb WHERE login = :login")
    fun get(login: String): UserDb

    @Insert
    fun addAll(listOf: List<UserDb>)

    @Query("DELETE FROM userdb")
    fun deleteAll()
}
