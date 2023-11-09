package com.carlostorres.promassblog.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.carlostorres.promassblog.R
import com.carlostorres.promassblog.databinding.FragmentDetailPostBinding
import com.carlostorres.promassblog.utils.viewUtils.setTimeStamp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPostFragment : Fragment() {

    private lateinit var binding: FragmentDetailPostBinding
    private val args: DetailPostFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailPostBinding.inflate(inflater)

        binding.apply {
            title.text = args.postData.title
            author.text = args.postData.author
            date.setTimeStamp(args.postData.timeStamp)
            overview.text = args.postData.overview
        }

        return binding.root
    }
}