package com.example.retrofit.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Retrofit.RetrofitInstance
import com.example.retrofit.data.Comment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QueryCommentsViewModel() : ViewModel() {

    private val _queryMutableStateFlow = MutableStateFlow<List<Comment>>(emptyList())
    val queryMutableStateFlow :StateFlow<List<Comment>> = _queryMutableStateFlow


    fun getQuery(query :Int)
    {
        viewModelScope.launch {
          val response =  RetrofitInstance.postApi.getCommentsQuery(query)
            if (response.isSuccessful)
            {
                Log.d("testApp" , " Success Query")
                response.body()?.let {
                    _queryMutableStateFlow.emit(it)
                }
            }
            else
            {
                Log.d("testApp" , "${response.code()}")
            }
        }
    }

}