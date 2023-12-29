package com.phro.initiativem.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phro.initiativem.model.Results
import com.phro.initiativem.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CharacterViewModel : ViewModel(), KoinComponent {

    private val characterRepository: CharacterRepository by inject()

    private val _characterStateFlow = MutableStateFlow<List<Results>?>(null)
    val characterStateFlow: StateFlow<List<Results>?> = _characterStateFlow

    fun getCharacterByName(name: String) {
        characterRepository.getCharacter(name) {
            _characterStateFlow.value = it
        }
    }
}