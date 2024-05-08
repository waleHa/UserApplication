package com.example.userapplication.data.Repository

import com.example.userapplication.domain.model.User.UserListResponseModel
import retrofit2.Response

interface UserRepository {
    suspend fun getUserFromRemoteDataSource() : Response<UserListResponseModel>
}