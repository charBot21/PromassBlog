package com.carlostorres.promassblog.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carlostorres.promassblog.data.local.entity.PostEntity
import com.carlostorres.promassblog.databinding.ItemPostBinding
import com.carlostorres.promassblog.domain.listener.PostClickListener

class PostAdapter(
    private val postList: List<PostEntity>,
    private val clickListener: PostClickListener
): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private lateinit var binding: ItemPostBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        holder.bind(postList[position], clickListener)
    }

    override fun getItemCount(): Int = postList.size

    inner class ViewHolder(): RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostEntity, noteListener: PostClickListener) {
            binding.post = post
            binding.listener = noteListener
        }
    }
}