package com.octo.archiexampleengie.android.user

import com.octo.archiexampleengie.core.workorder.UserInteractor

class UserControllerImpl(
    private val interactor: UserInteractor
) : UserController {
    override fun loadUsers() {
        interactor.loadUsers()
    }
}
