package com.example.userapplication.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapplication.core.ApiResponse
import com.example.userapplication.data.Repository.UserRepository
import com.example.userapplication.domain.model.User.UserListResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val TAG: String = "TAG: UserViewModel"

    private val _userRemoteModelResponse = MutableStateFlow<ApiResponse>(ApiResponse.Loading)
    val userRemoteModelResponse: StateFlow<ApiResponse> = _userRemoteModelResponse

    init {
        getUsers()
    }

    fun getUsers() {
        var response: Response<UserListResponseModel>
        viewModelScope.launch(Dispatchers.IO) {
            response = repository.getUserFromRemoteDataSource()
            try {
                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.i(TAG, "response.body()?.let ${it.userItemResponseModel}")
                        _userRemoteModelResponse.emit(ApiResponse.Success(requireNotNull(it.userItemResponseModel)))
                    }
                } else {
                    Log.e(TAG, "Error fetching users: ${response.errorBody()?.string()}")
                    _userRemoteModelResponse.emit(
                        ApiResponse.Failure(
                            response.errorBody().toString()
                        )
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception when fetching users", e)
                _userRemoteModelResponse.emit(ApiResponse.Failure(response.errorBody().toString()))
            }
        }
    }
}