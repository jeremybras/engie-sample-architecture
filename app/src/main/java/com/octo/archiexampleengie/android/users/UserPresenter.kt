package com.octo.archiexampleengie.android.users

import com.octo.archiexampleengie.R
import com.octo.archiexampleengie.core.users.User

class UserPresenter(
    private val view: UserView
) {
    fun presentError() {
        view.showError(R.string.repository_exception)
    }

    fun presentUsers(users: List<User>) {
        view.showUsers(users.map { transformUser(it) })
    }

    private fun transformUser(user: User): UserDisplayModel = UserDisplayModel(
        login = String.format("#%s %s", user.id.toString(), user.login),
        id = user.id.toString()
    )
}
