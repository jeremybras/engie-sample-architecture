package com.octo.archiexampleengie.android.user

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.octo.archiexampleengie.R
import com.octo.archiexampleengie.android.EngieApplication
import com.octo.archiexampleengie.android.common.viewmodel.ViewModelFactory
import com.octo.archiexampleengie.databinding.ActivityUsersBinding
import javax.inject.Inject

class UserActivity : AppCompatActivity() {

    @Inject lateinit var factory: ViewModelFactory<UserViewModel>

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        EngieApplication.getComponent(this).plus(UserModule()).inject(this)

        val binding: ActivityUsersBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_users
        )
        binding.setLifecycleOwner(this)

        viewModel = ViewModelProviders.of(this, factory).get(UserViewModel::class.java)

        initializeViewModelObservers()
    }

    private fun initializeViewModelObservers() {
        viewModel.data.observe(this, Observer { users ->
            println(users?.size)
        })
        viewModel.error.observe(this, Observer {

        })
    }
}