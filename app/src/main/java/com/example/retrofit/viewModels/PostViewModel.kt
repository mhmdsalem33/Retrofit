package com.example.retrofit.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.Retrofit.RetrofitInstance
import com.example.retrofit.data.Post
import kotlinx.coroutines.launch

class PostViewModel() :ViewModel() {


    private val _postLiveData = MutableLiveData<Post>()
    val postLiveData :LiveData<Post> = _postLiveData


    fun getPost(number : Int)
    {
        viewModelScope.launch {
            val response =  RetrofitInstance.postApi.getPost(number)
            if (response.isSuccessful)
            {
              //  Log.d("testApp" , response.body().toString())
             //   Log.d("testApp" , response.code().toString())

                response.body()?.let { data ->
                    _postLiveData.postValue(data)
                }
            }
            else
            {
              //  Log.d("testApp"  ,  "Failed " + response.code())
            }



        }
    }

}