package com.phro.initiativem.utils.services

import com.phro.initiativem.model.Base
import com.phro.initiativem.utils.auth.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {
    @GET("/v1/public/characters?ts=1&apikey=$API_KEY&hash=751b937c086f78b48251181590db01c0")
    fun getCharacterByName(
        @Query("name")
        name: String
    ): Call<Base>
}