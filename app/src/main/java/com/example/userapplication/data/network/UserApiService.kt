package com.example.userapplication.data.network

import com.example.userapplication.core.Constant
import com.example.userapplication.domain.model.User.UserListResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface UserApiService {
    @GET(Constant.END_POINT)
    suspend fun getUserFromRemoteDataSource(): Response<UserListResponseModel>
}