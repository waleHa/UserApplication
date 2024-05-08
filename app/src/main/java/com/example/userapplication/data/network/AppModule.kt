package com.example.userapplication.data.network

// File: AppModule.kt
import com.example.userapplication.core.Constant.BASE_URL
import com.example.userapplication.data.Repository.UserRepository
import com.example.userapplication.domain.Repository.UserRepositoryImp
import com.example.userapplication.ui.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    // Provide Retrofit service
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Ensure BASE_URL is correctly defined
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)
    }

    // Provide UserRepository
    single<UserRepository> { UserRepositoryImp(get()) }

    // Provide ViewModel
    viewModel { UserViewModel(get()) }
}
