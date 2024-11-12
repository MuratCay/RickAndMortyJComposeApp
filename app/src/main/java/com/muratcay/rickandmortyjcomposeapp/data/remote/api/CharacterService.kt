package com.muratcay.rickandmortyjcomposeapp.data.remote.api

import com.muratcay.rickandmortyjcomposeapp.data.model.RemoteCharacterPage
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(
        @QueryMap queryParams: Map<String, String>
    ): RemoteCharacterPage
}