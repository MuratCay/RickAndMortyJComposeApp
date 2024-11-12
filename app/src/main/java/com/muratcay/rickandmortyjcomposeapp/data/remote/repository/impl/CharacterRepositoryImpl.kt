package com.muratcay.rickandmortyjcomposeapp.data.remote.repository.impl

import com.muratcay.rickandmortyjcomposeapp.data.model.toDomainCharacter
import com.muratcay.rickandmortyjcomposeapp.data.model.toDomainCharacterPage
import com.muratcay.rickandmortyjcomposeapp.data.remote.api.CharacterService
import com.muratcay.rickandmortyjcomposeapp.data.remote.repository.CharacterRepository
import com.muratcay.rickandmortyjcomposeapp.domain.model.Character
import com.muratcay.rickandmortyjcomposeapp.domain.model.CharacterPage
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterService: CharacterService
) : CharacterRepository {

    private val characterCache = mutableMapOf<Int, Character>()

    override suspend fun getCharacters(
        pageNumber: Int,
        queryParams: Map<String, String>
    ): Result<CharacterPage> {
        return try {
            val params = queryParams.toMutableMap()
            params["page"] = pageNumber.toString()

            val remoteCharacterPage = characterService.getCharacters(params)
            Result.success(remoteCharacterPage.toDomainCharacterPage())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCharacter(id: Int): Result<Character> {
        characterCache[id]?.let { return Result.success(it) }
        return try {
            val remoteCharacter = characterService.getCharacter(id)
            val character = remoteCharacter.toDomainCharacter()
            characterCache[id] = character
            Result.success(character)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}