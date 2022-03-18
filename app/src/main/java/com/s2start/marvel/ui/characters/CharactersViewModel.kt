package com.s2start.marvel.ui.characters

import androidx.lifecycle.ViewModel
import com.s2start.marvel.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    val characters = repository.getCharacters()
}