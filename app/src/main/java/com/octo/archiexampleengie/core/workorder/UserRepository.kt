package com.octo.archiexampleengie.core.workorder

interface UserRepository {
    fun getUsers(): List<User>
    fun get(login: String): User
    fun removeAll()
    fun addAll(users: List<User>)
}
