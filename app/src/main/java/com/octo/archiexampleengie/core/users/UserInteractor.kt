package com.octo.archiexampleengie.core.users

import com.octo.archiexampleengie.android.users.UserPresenter
import com.octo.archiexampleengie.repository.RepositoryException

class UserInteractor(
    private val presenter: UserPresenter,
    private val dbRepository: UserRepository,
    private val apiRepository: UserRepository
) {
    fun loadUsers() {
        try {
            var users = dbRepository.getUsers()
            if (users.isEmpty()) {
                users = refreshUsers()
            }
            if (users.isNotEmpty()) {
                presenter.presentUsers(users.sortedBy { it.id })
            } else {
                presenter.presentError()
            }
        } catch (r: RepositoryException) {
            presenter.presentError()
        }
    }

    private fun refreshUsers() : List<User> {
        val users = apiRepository.getUsers()
        if (users.isNotEmpty()) {
            dbRepository.addAll(users)
        }
        return users
    }
}
