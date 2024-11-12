package com.muratcay.rickandmortyjcomposeapp.domain.usecase

import com.muratcay.rickandmortyjcomposeapp.data.remote.repository.CharacterRepository
import com.muratcay.rickandmortyjcomposeapp.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterById @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    operator fun invoke(id: Int) : Flow<Character> {
        return flow {
            val result = characterRepository.getCharacter(id)
            result.onSuccess { character ->
                emit(character)
            }.onFailure { exception ->
                // Hata durumunu yönetin
                // Örnek olarak hata mesajını gösterme:emit()
            }
        }
    }
}