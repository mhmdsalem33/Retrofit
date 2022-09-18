package com.example.retrofit.viewModels

import androidx.lifecycle.ViewModel
import com.example.retrofit.Repositroy.GetUserRepository
import com.example.retrofit.Retrofit.RetrofitInstance
import com.example.retrofit.data.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GetUserViewModel(
    private val repository: GetUserRepository
) : ViewModel() {

    private val _getUserByQueryStateFlow = MutableStateFlow<List<Post>>(emptyList())
    val getUserByQueryStateFlow :StateFlow<List<Post>> = _getUserByQueryStateFlow


    suspend fun getUserByQuery(userId : Int ,  sort :String , order : String )
    {
        val response = repository.getUserByQuery(userId , sort , order)
            response.body()?.let {  data ->
                _getUserByQueryStateFlow.emit(data)
            }
    }



    private val _getUserByQueryStateFlow2 = MutableStateFlow<List<Post>>(emptyList())
    val getUserByQueryStateFlow2 :StateFlow<List<Post>> = _getUserByQueryStateFlow2

    suspend fun getUserByQuery2(userId: Int , option: Map<String , String>)
    {
        val response = repository.getUserByQuery2(userId, option)
        if (response.isSuccessful)
        {
            response.body()?.let {
                _getUserByQueryStateFlow2.emit(it)
            }
        }
    }

}