package com.phro.initiativem.di

import com.phro.initiativem.repository.CharacterRepository
import com.phro.initiativem.ui.character.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    single {
        CharacterRepository()
    }
}
