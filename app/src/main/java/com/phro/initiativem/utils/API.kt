package com.phro.initiativem.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    companion object {
        fun marvelAPIConfig(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}