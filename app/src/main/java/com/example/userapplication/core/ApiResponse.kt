package com.example.userapplication.core

import com.example.userapplication.domain.model.User.UserItemResponseModel

sealed class ApiResponse {
    class Success(val user: List<UserItemResponseModel?>) : ApiResponse()
    class Failure(val message: String?) : ApiResponse()
    object Loading : ApiResponse()
}