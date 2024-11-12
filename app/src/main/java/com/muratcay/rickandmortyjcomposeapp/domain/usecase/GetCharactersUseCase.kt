package com.muratcay.rickandmortyjcomposeapp.domain.usecase

import com.muratcay.rickandmortyjcomposeapp.data.remote.repository.CharacterRepository
import com.muratcay.rickandmortyjcomposeapp.domain.model.CharacterPage
import com.muratcay.rickandmortyjcomposeapp.utils.ResourcesProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val resourcesProvider: ResourcesProvider
) {
    operator fun invoke(pageNumber: Int, queryParams: Map<String, String>): Flow<CharacterPage> {
        return flow {
            val result = characterRepository.getCharacters(pageNumber, queryParams)
            result.onSuccess { characterPage ->
                emit(characterPage)
            }.onFailure { exception ->
                // Hata durumunu yönetin
                // Örnek olarak hata mesajını gösterme:emit()
            }
        }
    }
}