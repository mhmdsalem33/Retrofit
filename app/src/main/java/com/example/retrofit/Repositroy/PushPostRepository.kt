package com.example.retrofit.Repositroy

import android.util.Log
import com.example.retrofit.Retrofit.RetrofitInstance
import com.example.retrofit.data.Post
import retrofit2.Response

class PushPostRepository {


    suspend fun pushPost(post: Post) :Response<Post>{
        val response = RetrofitInstance.postApi.pushPost(post)
        if (response.isSuccessful)
        {
            Log.d("testApp" , "Success To Push Post")
            Log.d("testApp"  , response.body().toString())
            Log.d("testApp"  , response.code().toString())
        }
        else
        {
            Log.d("testApp" , "Failed To Push Post")
            Log.d("testApp"  , response.code().toString())
        }
        return response
    }

}