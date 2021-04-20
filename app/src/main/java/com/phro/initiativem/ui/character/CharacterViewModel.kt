package com.phro.initiativem.ui.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phro.initiativem.model.Results
import com.phro.initiativem.repository.CharacterRepository

class CharacterViewModel(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private var characterLiveData = MutableLiveData<List<Results>>()

    fun getCharacterByName(name: String): MutableLiveData<List<Results>> {
        characterLiveData = characterRepository.getCharacter(name)

        return characterLiveData
    }
}