package com.example.userapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.userapplication.core.ApiResponse
import com.example.userapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by inject()
    val adapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewUser.adapter = adapter

        observerHandler(adapter)
    }

    private fun observerHandler(adapter: UserAdapter) {
        lifecycleScope.launch {
            viewModel.userRemoteModelResponse.collect {
                when (it) {
                    is ApiResponse.Success -> {
                        binding.progressBarMusician.visibility = View.GONE
                        adapter.submitList(it.user)
                    }

                    is ApiResponse.Failure -> {
                        binding.progressBarMusician.visibility = View.GONE
                        Log.e("TAG: UserActivity", it.message.toString())
                    }

                    is ApiResponse.Loading -> binding.progressBarMusician.visibility = View.VISIBLE
                }
//                adapter.submitList(it)
            }
        }

    }
}