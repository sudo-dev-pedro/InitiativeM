package com.phro.initiativem.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.phro.initiativem.model.Base
import com.phro.initiativem.model.Data
import com.phro.initiativem.model.Results
import com.phro.initiativem.utils.API
import com.phro.initiativem.utils.services.CharacterService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {

    fun getCharacter(name: String): MutableLiveData<List<Results>> {

        val marvelClient = API.marvelAPIConfig()
        val endpoint = marvelClient.create(CharacterService::class.java)
        val callback = endpoint.getCharacterByName(name)

        val characterLiveData = MutableLiveData<List<Results>>()

        callback.enqueue(
            object : Callback<Base> {

                override fun onFailure(call: Call<Base>, t: Throwable) {
                    Log.d("Erro!", "Falhamos, parça!")
                }

                override fun onResponse(call: Call<Base>, response: Response<Base>) {
                    if (response.isSuccessful) {
                        characterLiveData.value = response.body()?.data?.results
                    }
                }
            })

        return characterLiveData
    }
}