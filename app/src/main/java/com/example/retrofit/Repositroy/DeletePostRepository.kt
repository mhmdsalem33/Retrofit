package com.example.retrofit.Repositroy

import android.util.Log
import com.example.retrofit.Retrofit.RetrofitInstance
import javax.inject.Inject

class DeletePostRepository @Inject constructor() {
    suspend fun deletePost(number : Int ) {
        val response = RetrofitInstance.postApi.deletePost(number)
        if (response.isSuccessful)
        {
            Log.d("testApp" , "Success To Delete Post")
            Log.d("testApp" ,  response.body().toString())
            Log.d("testApp" ,  response.code().toString())
        }
        else
        {
            Log.d("testApp" , "Failed To Delete Post")
            Log.d("testApp" , response.code().toString())
        }
    }
}