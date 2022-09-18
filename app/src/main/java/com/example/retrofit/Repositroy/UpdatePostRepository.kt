package com.example.retrofit.Repositroy

import android.util.Log
import com.example.retrofit.Retrofit.RetrofitInstance
import com.example.retrofit.data.Post
import retrofit2.Response
import retrofit2.Retrofit

class UpdatePostRepository {
    suspend fun updateRepository(postNumber : Int  , title : String) : Response<Post>
    {
        val response = RetrofitInstance.postApi.updatePost(postNumber , title)
        if (response.isSuccessful)
        {
            Log.d("testApp" , "Success To Updated Post")
            Log.d("testApp" , response.body().toString())
            Log.d("testApp" , response.code().toString())
        }
        else
        {
            Log.d("testApp" , "Failed To Updated Post")
            Log.d("testApp" , response.code().toString())
        }
        return response
    }

}