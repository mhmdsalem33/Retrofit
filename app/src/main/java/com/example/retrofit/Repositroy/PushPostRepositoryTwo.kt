package com.example.retrofit.Repositroy

import android.util.Log
import com.example.retrofit.Retrofit.RetrofitInstance
import com.example.retrofit.data.Post
import retrofit2.Response
import retrofit2.http.Body

class PushPostRepositoryTwo {

    suspend fun  pushPostTwo(userId : Int , id : Int , title : String , body: String) :Response<Post>{
        val response = RetrofitInstance.postApi.pushPost2(userId , id , title , body)
        if (response.isSuccessful)
        {
            Log.d("testApp" ,"Push Post Two Success ")
            Log.d("testApp" , response.body().toString())
            Log.d("testApp" , response.code().toString())
        }
        else
        {
            Log.d("testApp" , response.code().toString())
            Log.d("testApp" , "Failed To Push Post Two")
        }
        return  response
    }
}