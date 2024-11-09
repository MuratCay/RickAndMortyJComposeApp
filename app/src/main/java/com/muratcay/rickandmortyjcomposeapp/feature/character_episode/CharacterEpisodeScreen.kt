package com.muratcay.rickandmortyjcomposeapp.feature.character_episode

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun CharacterEpisodeRoute(
    modifier: Modifier = Modifier,
    viewModel: CharacterEpisodeViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    CharacterEpisodeScreen(modifier = modifier, characterEpisodeUiState = uiState.value)
}

@Composable
fun CharacterEpisodeScreen(modifier: Modifier, characterEpisodeUiState: CharacterEpisodeUiState) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "CharacterEpisodeScreen")
    }
}
