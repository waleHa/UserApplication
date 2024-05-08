package com.example.userapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.userapplication.databinding.ActivityMainBinding
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
        viewModel.userRemoteModelSuccess.observe(this){
            adapter.submitList(it)
        }
    }
}