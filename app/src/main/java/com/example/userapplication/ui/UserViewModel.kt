package com.example.userapplication.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapplication.data.Repository.UserRepository
import com.example.userapplication.domain.model.User.UserItemResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    private val TAG: String = "TAG: UserViewModel"

    private val _userRemoteModelSuccess = MutableLiveData<List<UserItemResponseModel?>>()
    val userRemoteModelSuccess: LiveData<List<UserItemResponseModel?>> = _userRemoteModelSuccess

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getUserFromRemoteDataSource()

                if (response.isSuccessful) {
                    response.body()?.let {
                        Log.i(TAG, "response.body()?.let")
                        _userRemoteModelSuccess.postValue(requireNotNull(it.userItemResponseModel))
                    }
                } else {
                    Log.e(TAG, "Error fetching users: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e(TAG, "Exception when fetching users", e)
            }
        }
    }
}