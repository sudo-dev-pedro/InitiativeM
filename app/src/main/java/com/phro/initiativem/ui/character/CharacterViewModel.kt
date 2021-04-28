package com.phro.initiativem.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phro.initiativem.model.Results
import com.phro.initiativem.repository.CharacterRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class CharacterViewModel : ViewModel(), KoinComponent {

    private val characterRepository: CharacterRepository by inject()

    private val _characterLiveData = MutableLiveData<List<Results>>()
    val characterLiveData: LiveData<List<Results>>
        get() = _characterLiveData

    fun getCharacterByName(name: String) {
        characterRepository.getCharacter(name) {
            _characterLiveData.postValue(it)
        }
    }
}