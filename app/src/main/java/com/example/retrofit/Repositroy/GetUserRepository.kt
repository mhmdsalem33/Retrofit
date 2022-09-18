package com.example.retrofit.Repositroy

import android.util.Log
import com.example.retrofit.Retrofit.RetrofitInstance
import com.example.retrofit.data.Post
import retrofit2.Response

class GetUserRepository {

    suspend fun getUserByQuery(userId : Int ,  sort :String , order : String) : Response<List<Post>>{
      val response =   RetrofitInstance.postApi.getUserByQuery(userId , sort , order)
        if (response.isSuccessful)
        {
            Log.d("testApp" , "Success get user by Query")
        }
        else
        {
            Log.d("testApp" , response.code().toString())
            Log.d("testApp" , response.errorBody().toString())
        }
        return  response
    }



    suspend fun getUserByQuery2(userId : Int , option : Map<String , String>) : Response<List<Post>>{
        val response =   RetrofitInstance.postApi.getUserByQuery2(userId ,option)
        if (response.isSuccessful)
        {
            Log.d("testApp" , "Success get user by Query")
        }
        else
        {
            Log.d("testApp" , response.code().toString())
            Log.d("testApp" , response.errorBody().toString())
        }
        return  response
    }








}