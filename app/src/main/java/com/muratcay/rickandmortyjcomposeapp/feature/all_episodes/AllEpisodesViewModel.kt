package com.muratcay.rickandmortyjcomposeapp.feature.all_episodes

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AllEpisodesViewModel @Inject constructor() : ViewModel() {

    private val _uiState: MutableStateFlow<AllEpisodesUiState> = MutableStateFlow(AllEpisodesUiState())
    val uiState: StateFlow<AllEpisodesUiState> = _uiState.asStateFlow()

}