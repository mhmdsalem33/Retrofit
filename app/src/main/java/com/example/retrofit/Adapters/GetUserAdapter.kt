package com.example.retrofit.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.data.Post
import com.example.retrofit.databinding.UserRowBinding

class GetUserAdapter() : RecyclerView.Adapter<GetUserAdapter.ViewHolder>() {
    private val diffUtil = object  : DiffUtil.ItemCallback<Post>(){
        override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
          return  oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this , diffUtil)

    class ViewHolder (val binding : UserRowBinding) :RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return  ViewHolder(UserRowBinding.inflate(LayoutInflater.from(parent.context) , parent , false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

       val data = differ.currentList[position]
        holder.binding.userId.text  = data.userId.toString()
        holder.binding.Id.text      =  data.id.toString()
        holder.binding.apply {
            userTitle.text = data.title
            userBody.text  = data.body
        }
    }

    override fun getItemCount() = differ.currentList.size

}