package com.muratcay.rickandmortyjcomposeapp.data.remote.api

import com.muratcay.rickandmortyjcomposeapp.data.model.RemoteCharacter
import com.muratcay.rickandmortyjcomposeapp.data.model.RemoteCharacterPage
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface CharacterService {

    @GET("character")
    suspend fun getCharacters(
        @QueryMap queryParams: Map<String, String>
    ): RemoteCharacterPage

    @GET("character/{id}")
    suspend fun getCharacter(
        @Path("id") id: Int
    ): RemoteCharacter
}