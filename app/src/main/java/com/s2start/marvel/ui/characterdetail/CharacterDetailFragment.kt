package com.s2start.marvel.ui.characterdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.s2start.marvel.data.entities.Character
import com.s2start.marvel.databinding.CharacterDetailFragmentBinding
import com.s2start.marvel.utils.Resource
import com.s2start.marvel.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {
    private var binding: CharacterDetailFragmentBinding by autoCleared()
    private val viewModel: CharacterDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CharacterDetailFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("id")?.let { viewModel.start(it) }
        setupObservers()
    }

    private fun setupObservers(){
        viewModel.character.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Resource.Status.SUCCESS -> {
                    bindCharacter(it.data!!)
                    binding.progressBar.visibility = View.GONE
                    binding.characterCl.visibility = View.VISIBLE
                }
                Resource.Status.ERROR -> {

                }
                Resource.Status.LOADING -> {

                }
            }
        })
    }
    private fun bindCharacter(character: Character){
        binding.name.text = character.name
        Glide.with(binding.root)
            .load("${character.thumbnail?.path}.${character.thumbnail?.extension}")
            .transform(CircleCrop())
            .into(binding.image)
    }
}