package com.example.userapplication.domain.model.User


import com.google.gson.annotations.SerializedName

data class UserListResponseModel(
    @SerializedName("data")
    val userItemResponseModel: List<UserItemResponseModel?>? = listOf()
)