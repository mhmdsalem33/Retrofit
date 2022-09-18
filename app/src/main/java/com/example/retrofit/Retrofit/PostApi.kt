package com.example.retrofit.Retrofit

import com.example.retrofit.data.Comment
import com.example.retrofit.data.Post
import retrofit2.Response
import retrofit2.http.*

interface PostApi {

    @GET("posts")
    suspend fun getPosts() :Response<List<Post>>

    @GET("posts/{postNumber}")
    suspend fun getPost(@Path("postNumber") number :Int)  :Response<Post>

    @GET("/posts/{postNumber}/comments")
    suspend fun getComments(@Path("postNumber") number: Int) :Response<List<Comment>>

    @GET("comments")
    suspend fun getCommentsQuery(@Query("postId") id: Int) :Response<List<Comment>>


    //https://jsonplaceholder.typicode.com/posts?userId=1&sort=id&order=desc

    @GET("posts")
    suspend fun getUserByQuery(
        @Query("userId")  userId : Int,
        @Query("_sort")   sort   : String,
        @Query("_order")  order  : String
    ) :Response<List<Post>>


    @GET("posts")
    suspend fun getUserByQuery2(
        @Query("userId")  userId : Int,
        @QueryMap option : Map<String , String>
    ) :Response<List<Post>>


    @POST("posts")
    suspend fun pushPost(
        @Body post: Post
    ) :Response<Post>

/*
    @PUT("posts/1")
    suspend fun pushPost(
        @Body post: Post
    ) :Response<Post>

 */

    @FormUrlEncoded
    @POST("posts")
    suspend fun pushPost2(
        @Field("userId")  userId : Int,
        @Field("id")      id     : Int    ,
        @Field("title")   title  : String,
        @Field("body")    body   : String
    )  : Response<Post>



    @FormUrlEncoded
    @PATCH("posts/{pathNumber}")
    suspend fun updatePost(
      @Path("pathNumber")  number :Int ,
      @Field("title")      title: String
    ) : Response<Post>



    @DELETE("posts/{pathNumber}")
    suspend fun deletePost(
        @Path("pathNumber") number: Int
    ) : Response<Post>


}