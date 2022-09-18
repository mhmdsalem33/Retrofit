package com.example.retrofit.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Repositroy.PushPostRepositoryTwo
import kotlinx.coroutines.launch
import retrofit2.http.Body

class PushPostViewModelTwo(
    private val pushPostRepoTwo : PushPostRepositoryTwo
) : ViewModel() {

    fun pushPostTwo (userId : Int , id : Int , title :String , body: String) {
        viewModelScope.launch {
            val response = pushPostRepoTwo.pushPostTwo(userId , id , title , body)
            if (response.isSuccessful)
            {

            }
        }
    }

}