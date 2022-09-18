package com.example.retrofit.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Retrofit.RetrofitInstance
import com.example.retrofit.data.Post
import kotlinx.coroutines.launch

class PostsViewModel() : ViewModel() {

    private val _getPost = MutableLiveData<List<Post>>()
    val getPost :LiveData<List<Post>> = _getPost


    fun getPosts(){
        viewModelScope.launch {
            val response = RetrofitInstance.postApi.getPosts()
            if (response.isSuccessful)
            {
                //Log.d("testApp" , response.body().toString())
              //  Log.d("testApp" , response.code().toString())
               // Log.d("testApp" , response.message().toString())

                response.body()?.let { data ->
                    _getPost.postValue(data)
                }

            }
            else
            {
               // Log.d("testApp" , response.code().toString())
               // Log.d("testApp" , response.errorBody().toString())
            }
        }
    }


}