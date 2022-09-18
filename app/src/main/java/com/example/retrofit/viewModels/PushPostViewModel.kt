package com.example.retrofit.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Repositroy.PushPostRepository
import com.example.retrofit.data.Post
import kotlinx.coroutines.launch

class PushPostViewModel(
    private val pushPostRepository : PushPostRepository
) : ViewModel() {


    fun pushPost(post: Post){
        viewModelScope.launch {
            val response = pushPostRepository.pushPost(post)
            if (response.isSuccessful)
            {

            }
        }
    }

}