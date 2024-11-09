package com.muratcay.rickandmortyjcomposeapp.feature.character_episode

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterEpisodeViewModel @Inject constructor() : ViewModel() {

    private val _uiState: MutableStateFlow<CharacterEpisodeUiState> = MutableStateFlow(CharacterEpisodeUiState())
    val uiState: StateFlow<CharacterEpisodeUiState> = _uiState.asStateFlow()

}