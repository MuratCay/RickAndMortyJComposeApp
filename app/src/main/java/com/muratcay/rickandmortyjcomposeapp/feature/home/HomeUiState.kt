package com.muratcay.rickandmortyjcomposeapp.feature.home

import com.muratcay.rickandmortyjcomposeapp.domain.model.Character

data class HomeUiState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: Throwable? = null
)
