package com.example.retrofit.viewModels.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.Repositroy.GetUserRepository
import com.example.retrofit.viewModels.GetUserViewModel

class GetUserViewModelFactory (
    private val repository: GetUserRepository
         ): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GetUserViewModel(repository) as T
    }
}