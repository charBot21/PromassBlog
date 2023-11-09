package com.carlostorres.promassblog.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.carlostorres.promassblog.R
import com.carlostorres.promassblog.databinding.FragmentBlogBinding
import com.carlostorres.promassblog.ui.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlogFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentBlogBinding
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlogBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllPosts()

        viewModel.posts.observe(viewLifecycleOwner) {
            count = if ( it.isEmpty() ) {
                0
            } else {
                it.size
            }
        }

        viewModel.postClicked.observe(viewLifecycleOwner) {post ->
            post.getContentIfNotHandled()?.let {
                findNavController().navigate(BlogFragmentDirections.actionBlogFragmentToDetailPostFragment(it))
            }
        }

        binding.apply {
            fbAddPost.setOnClickListener {
                findNavController().navigate(BlogFragmentDirections.actionBlogFragmentToAddPostFragment(count))
            }
        }
    }
}