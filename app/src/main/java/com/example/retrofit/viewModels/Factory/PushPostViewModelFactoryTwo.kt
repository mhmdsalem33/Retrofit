package com.example.retrofit.viewModels.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.Repositroy.PushPostRepositoryTwo
import com.example.retrofit.viewModels.PushPostViewModelTwo

class PushPostViewModelFactoryTwo (
    private val repo : PushPostRepositoryTwo
        ) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PushPostViewModelTwo(repo) as T
    }
}