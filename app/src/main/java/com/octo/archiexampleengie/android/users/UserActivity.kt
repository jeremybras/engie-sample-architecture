package com.octo.archiexampleengie.android.users

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.octo.archiexampleengie.R
import com.octo.archiexampleengie.android.EngieApplication
import com.octo.archiexampleengie.android.common.viewmodel.ViewModelFactory
import com.octo.archiexampleengie.databinding.ActivityUsersBinding
import kotlinx.android.synthetic.main.activity_users.*
import javax.inject.Inject

class UserActivity : AppCompatActivity(), UserAdapterListener {
    @Inject lateinit var factory: ViewModelFactory<UserViewModel>

    private lateinit var adapter: UsersAdapter
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

        adapter = UsersAdapter(emptyList(), this, this)
        usersRecyclerView.layoutManager = LinearLayoutManager(this)
        usersRecyclerView.adapter = adapter

        initializeViewModelObservers()
    }

    private fun initializeViewModelObservers() {
        viewModel.data.observe(this, Observer { users ->
            users?.let {
                adapter.updateData(it)
            }
        })
        viewModel.error.observe(this, Observer {

        })
    }

    override fun onUserClicked(user: UserDisplayModel) {
        Toast.makeText(this, "Clicked on user #$user.id", Toast.LENGTH_SHORT).show()
    }
}
