package com.example.retrofit.viewModels.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.Repositroy.UpdatePostRepository

class UpdatePostViewModelFactory (
    private val updatePostRepository: UpdatePostRepository
        ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UpdatePostViewModel(updatePostRepository) as T
    }
}