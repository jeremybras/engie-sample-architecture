package com.octo.archiexampleengie.android.users

import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.annotation.StringRes
import com.octo.archiexampleengie.android.common.SingleLiveEvent
import timber.log.Timber

class UserViewModel(
    controller: UserController
) : ViewModel(), UserView, LifecycleObserver {

    val data: MutableLiveData<List<UserDisplayModel>> = MutableLiveData()
    val error: SingleLiveEvent<Int> = SingleLiveEvent()

    init {
        controller.loadUsers()
    }

    override fun showUsers(users: List<UserDisplayModel>) {
        Timber.d("Displaying $users")
        this.data.value = users
    }

    override fun showError(@StringRes errorMessage: Int) {
        error.value = errorMessage
    }
}
