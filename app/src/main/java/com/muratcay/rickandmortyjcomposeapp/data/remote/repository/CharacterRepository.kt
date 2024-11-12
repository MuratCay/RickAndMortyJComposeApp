package com.muratcay.rickandmortyjcomposeapp.data.remote.repository

import com.muratcay.rickandmortyjcomposeapp.domain.model.Character
import com.muratcay.rickandmortyjcomposeapp.domain.model.CharacterPage

interface CharacterRepository {
    suspend fun getCharacters(pageNumber: Int, queryParams: Map<String, String>): Result<CharacterPage>
    suspend fun getCharacter(id: Int): Result<Character>
}