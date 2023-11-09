package com.carlostorres.promassblog.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.carlostorres.promassblog.R
import com.carlostorres.promassblog.databinding.FragmentAddPostBinding
import com.carlostorres.promassblog.domain.listener.AddPostListener
import com.carlostorres.promassblog.ui.viewmodels.AddViewModel
import com.carlostorres.promassblog.utils.viewUtils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddPostFragment : Fragment(), AddPostListener {

    private val viewModel: AddViewModel by viewModels()
    private lateinit var binding: FragmentAddPostBinding
    private val args: AddPostFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddPostBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.vm = viewModel
        viewModel.listener = this

        binding.apply {
            floatingSave.setOnClickListener {
                viewModel.saveData(args.position+1)
            }
        }

        return binding.root
    }

    override fun onEmptyFields() {
        toast(R.string.empty_input)
    }

    override fun success() {
        findNavController().navigate(AddPostFragmentDirections.actionAddPostFragmentToBlogFragment())
    }

}