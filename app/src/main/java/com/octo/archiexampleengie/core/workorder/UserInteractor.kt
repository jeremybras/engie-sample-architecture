package com.octo.archiexampleengie.core.workorder

import com.octo.archiexampleengie.android.user.UserPresenter
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
            presenter.presentUsers(users)
        } catch (r: RepositoryException) {
            presenter.presentError()
        }
    }

    private fun refreshUsers() : List<User> {
        val users = apiRepository.getUsers()
        dbRepository.addAll(users)
        return users
    }
}
