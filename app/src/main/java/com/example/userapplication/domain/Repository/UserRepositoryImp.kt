package com.example.userapplication.domain.Repository

import com.example.userapplication.data.Repository.UserRepository
import com.example.userapplication.data.network.UserApiService
import com.example.userapplication.domain.model.User.UserListResponseModel
import retrofit2.Response

class UserRepositoryImp(private val userApiService: UserApiService) : UserRepository {
    override suspend fun getUserFromRemoteDataSource(): Response<UserListResponseModel> {
        return userApiService.getUserFromRemoteDataSource()
    }
}