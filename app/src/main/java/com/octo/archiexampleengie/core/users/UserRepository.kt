package com.octo.archiexampleengie.core.users

import com.octo.archiexampleengie.repository.RepositoryException

interface UserRepository {
    @Throws(RepositoryException::class)
    fun getUsers(): List<User>

    fun get(login: String): User
    fun removeAll()
    fun addAll(users: List<User>)
}
