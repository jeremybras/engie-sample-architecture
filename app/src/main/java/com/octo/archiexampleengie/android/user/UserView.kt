package com.octo.archiexampleengie.android.user

import android.support.annotation.StringRes
import com.octo.workerdecorator.annotation.Decorate

@Decorate(weak = true, mutable = true)
interface UserView {
    fun showUsers(users: List<UserDisplayModel>)
    fun showError(@StringRes errorMessage: Int)
}
