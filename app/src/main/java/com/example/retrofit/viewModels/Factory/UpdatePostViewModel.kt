package com.example.retrofit.viewModels.Factory

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Repositroy.UpdatePostRepository
import kotlinx.coroutines.launch

class UpdatePostViewModel (
    private val updateRepo : UpdatePostRepository
        ) :ViewModel()
{
            fun updatePost(postNumber : Int , title :String)
            {
                viewModelScope.launch {
                    val response = updateRepo.updateRepository(postNumber , title)
                    if (response.isSuccessful)
                    {
                        Log.d("testApp" , "Sucess")
                    }
                }
            }
}