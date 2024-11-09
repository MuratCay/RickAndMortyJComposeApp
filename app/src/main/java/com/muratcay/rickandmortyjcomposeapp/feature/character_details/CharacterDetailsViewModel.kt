package com.muratcay.rickandmortyjcomposeapp.feature.character_details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor() : ViewModel() {

    private val _uiState: MutableStateFlow<CharacterDetailsUiState> = MutableStateFlow(CharacterDetailsUiState())
    val uiState: StateFlow<CharacterDetailsUiState> = _uiState.asStateFlow()
}