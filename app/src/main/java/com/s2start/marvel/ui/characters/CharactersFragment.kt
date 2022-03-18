package com.s2start.marvel.ui.characters

import android.content.AbstractThreadedSyncAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.s2start.marvel.R
import com.s2start.marvel.databinding.CharactersFragmentBinding
import com.s2start.marvel.utils.Resource
import com.s2start.marvel.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {
    private var binding: CharactersFragmentBinding by autoCleared()
    private val viewModel: CharactersViewModel by viewModels()

    //criar adapter
//    private lateinit var adapter: AbstractThreadedSyncAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharactersFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.characters.observe(viewLifecycleOwner, Observer {
            when (it.status){
                Resource.Status.SUCCESS -> {
                    binding.message.setText("${it.message} \n ${it.data}")
                }
                Resource.Status.ERROR -> println("#DEVMATHEUS ERROR  ${it.message}")
                Resource.Status.LOADING -> println("#DEVMATHEUS LOADING  ${it.message}")
            }
            if(it.message != null)
                binding.message.setText("${it.message} \n ${it.status.name}")
        })
    }
}