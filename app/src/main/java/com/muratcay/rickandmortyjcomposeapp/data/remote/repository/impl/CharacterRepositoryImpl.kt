package com.muratcay.rickandmortyjcomposeapp.data.remote.repository.impl

import com.muratcay.rickandmortyjcomposeapp.data.model.toDomainCharacterPage
import com.muratcay.rickandmortyjcomposeapp.data.remote.api.CharacterService
import com.muratcay.rickandmortyjcomposeapp.data.remote.repository.CharacterRepository
import com.muratcay.rickandmortyjcomposeapp.domain.model.CharacterPage
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterService: CharacterService
) : CharacterRepository {
    override suspend fun getCharacters(pageNumber: Int, queryParams: Map<String, String>): Result<CharacterPage> {
        return try {
            val params = queryParams.toMutableMap()
            params["page"] = pageNumber.toString()

            val remoteCharacterPage = characterService.getCharacters(params)
            Result.success(remoteCharacterPage.toDomainCharacterPage())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}