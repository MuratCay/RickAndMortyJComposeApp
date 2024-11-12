package com.muratcay.rickandmortyjcomposeapp.domain.model

sealed class CharacterStatus(val displayName: String) {
    object Alive: CharacterStatus("Alive")
    object Dead: CharacterStatus("Dead")
    object Unknown: CharacterStatus("Unknown")
}