package com.octo.archiexampleengie.android.users

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.octo.archiexampleengie.databinding.ItemUserBinding

class UsersAdapter(
    private var users: List<UserDisplayModel>,
    private val listener: UserAdapterListener,
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        return DailyRoadmapInterventionViewHolder(
            listener,
            ItemUserBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DailyRoadmapInterventionViewHolder).bind(users[position])
    }

    fun updateData(list: List<UserDisplayModel>) {
        users = list
        notifyDataSetChanged()
    }
}

class DailyRoadmapInterventionViewHolder(
    private val listener: UserAdapterListener,
    private val binding: ItemUserBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: UserDisplayModel) {
        binding.user = data
        binding.userConstraintLayout.setOnClickListener {
            listener.onUserClicked(data)
        }
    }
}

interface UserAdapterListener {
    fun onUserClicked(user: UserDisplayModel)
}
