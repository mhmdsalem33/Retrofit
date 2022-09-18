package com.example.retrofit.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Repositroy.DeletePostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeletePostViewModel @Inject constructor (
    private val deleteRepository : DeletePostRepository
        ) : ViewModel()
{
    fun deletePost(number : Int)
    {
        viewModelScope.launch {
            deleteRepository.deletePost(number)
        }
    }
}