package com.example.retrofit.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Retrofit.RetrofitInstance
import com.example.retrofit.data.Comment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CommentsViewModel() : ViewModel() {


    private val _getCommentsMutableStateFlow = MutableStateFlow<List<Comment>>(emptyList())
    val getCommentsMutableStateFlow : StateFlow<List<Comment>> = _getCommentsMutableStateFlow



    fun getComments(number: Int)
    {
        viewModelScope.launch {
            val response = RetrofitInstance.postApi.getComments(number)
            if (response.isSuccessful)
            {
                Log.d("testApp" , " Success")
                response.body()?.let {
                    _getCommentsMutableStateFlow.emit(it)
                }
            }
            else
            {
                Log.d("testApp" , "Failed ${response.code()}")
            }
        }
    }


}