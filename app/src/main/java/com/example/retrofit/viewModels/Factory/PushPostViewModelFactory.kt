package com.example.retrofit.viewModels.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.Repositroy.PushPostRepository
import com.example.retrofit.viewModels.PushPostViewModel

class PushPostViewModelFactory (
    private val repo : PushPostRepository
        ) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PushPostViewModel(repo) as T
    }
}