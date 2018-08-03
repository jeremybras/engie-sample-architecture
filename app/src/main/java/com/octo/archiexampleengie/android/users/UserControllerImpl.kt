package com.octo.archiexampleengie.android.users

import com.octo.archiexampleengie.core.users.UserInteractor

class UserControllerImpl(
    private val interactor: UserInteractor
) : UserController {
    override fun loadUsers() {
        interactor.loadUsers()
    }
}
