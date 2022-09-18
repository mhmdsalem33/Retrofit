package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.Adapters.GetUserAdapter
import com.example.retrofit.Repositroy.GetUserRepository
import com.example.retrofit.Repositroy.PushPostRepository
import com.example.retrofit.Repositroy.PushPostRepositoryTwo
import com.example.retrofit.Repositroy.UpdatePostRepository
import com.example.retrofit.data.Post
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.viewModels.*
import com.example.retrofit.viewModels.Factory.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var postsMvvm   : PostsViewModel
    private lateinit var postMvvm    : PostViewModel
    private lateinit var commentMvvm : CommentsViewModel
    private lateinit var queryMvvm   : QueryCommentsViewModel

    private val getUserByQueryMvvm   : GetUserViewModel by lazy {
        val repository  = GetUserRepository()
        val factory     = GetUserViewModelFactory(repository)
        ViewModelProvider(this , factory)[GetUserViewModel::class.java]
    }

    private val pushPostViewModel : PushPostViewModel by lazy {
        val repository = PushPostRepository()
        val factory    = PushPostViewModelFactory(repository)
        ViewModelProvider(this , factory)[PushPostViewModel::class.java]
    }



    private val pushPostViewModelTwo : PushPostViewModelTwo by lazy {
        val repository = PushPostRepositoryTwo()
        val factory    = PushPostViewModelFactoryTwo(repository)
        ViewModelProvider(this , factory = factory) [PushPostViewModelTwo::class.java]
    }


    private val updatePostMvvm : UpdatePostViewModel by lazy {
        val repository = UpdatePostRepository()
        val factory    = UpdatePostViewModelFactory(repository)
        ViewModelProvider(this , factory)[UpdatePostViewModel::class.java]
    }


    private val deleteMvvm : DeletePostViewModel by viewModels()

    private lateinit var userAdapter : GetUserAdapter
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        postsMvvm    = ViewModelProviders.of(this)[PostsViewModel::class.java]
        postMvvm     = ViewModelProviders.of(this)[PostViewModel::class.java]
        commentMvvm  = ViewModelProviders.of(this)[CommentsViewModel::class.java]
        queryMvvm    = ViewModelProviders.of(this)[QueryCommentsViewModel::class.java]
        userAdapter  = GetUserAdapter()


        postsMvvm.getPosts()
        postsMvvm.getPost.observe(this){ data ->
          //  Log.d("testApp" , data.toString())
        }


        postMvvm.getPost(2)
        postMvvm.postLiveData.observe(this){ data ->
           // Log.d("testApp" , data.toString())


        }


        commentMvvm.getComments(4)

        lifecycleScope.launchWhenStarted {
            commentMvvm.getCommentsMutableStateFlow.collect{ data ->
              //  Log.d("testApp" , data.toString())

            }
        }



        queryMvvm.getQuery(3)
        lifecycleScope.launchWhenStarted {
            queryMvvm.queryMutableStateFlow.collect{ data ->
              //  Log.d("testApp" , data.toString())
            }
        }

       lifecycleScope.launchWhenStarted {
           getUserByQueryMvvm.getUserByQuery(1 , "id" , "asc")
           getUserByQueryMvvm.getUserByQueryStateFlow.collect{ data ->
             //  Log.d("testApp" ,  data.toString())

              // userAdapter.differ.submitList(data)

           }
       }

    lifecycleScope.launchWhenStarted {
        val map = HashMap<String , String>()
            map["_sort"] = "id"
            map["order"] = "asc"


        getUserByQueryMvvm.getUserByQuery2(1 ,  map )
        getUserByQueryMvvm.getUserByQueryStateFlow2.collect{
           // userAdapter.differ.submitList(it)
        }

    }


        binding.pushPost.setOnClickListener {
            val post = Post(1 , 1 , "Mohamed Salem" , "Hello From Test")
            lifecycleScope.launchWhenStarted {
              //  pushPostViewModel.pushPost(post)
             //  pushPostViewModelTwo.pushPostTwo(1 , 101 , "Hello" , "hgfjskhgskdjhgskjd")

            //    updatePostMvvm.updatePost(1 , "Hello It's New Title")
                deleteMvvm.deletePost(1)
            }
        }



        binding.recView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter       = userAdapter
        }

    }



}