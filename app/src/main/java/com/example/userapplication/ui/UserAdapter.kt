package com.example.userapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.userapplication.R
import com.example.userapplication.databinding.ItemUserBinding
import com.example.userapplication.domain.model.User.UserItemResponseModel

class UserAdapter : ListAdapter<UserItemResponseModel, UserAdapter.UserViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userItem: UserItemResponseModel) {
            Glide.with(binding.imageViewUserItem.context)
                .load(userItem.avatar)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.imageViewUserItem)
            binding.textViewUserName.text = "${userItem.firstName} ${userItem.lastName}"
            binding.textViewUserEmail.text = "${userItem.email}"
        }
    }

    companion object {
        private val DiffCallBack = object : DiffUtil.ItemCallback<UserItemResponseModel>() {
            override fun areItemsTheSame(
                oldItem: UserItemResponseModel,
                newItem: UserItemResponseModel
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: UserItemResponseModel,
                newItem: UserItemResponseModel
            ) = oldItem == newItem
        }
    }
}