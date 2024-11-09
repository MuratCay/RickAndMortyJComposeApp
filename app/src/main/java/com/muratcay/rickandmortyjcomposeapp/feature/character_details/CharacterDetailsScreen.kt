package com.muratcay.rickandmortyjcomposeapp.feature.character_details

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
internal fun CharacterDetailsRoute(
    modifier: Modifier = Modifier,
    viewModel: CharacterDetailsViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    CharacterDetailsScreen(modifier = modifier, characterDetailsUiState = uiState.value)
}

@Composable
fun CharacterDetailsScreen(
    modifier: Modifier = Modifier,
    characterDetailsUiState: CharacterDetailsUiState
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "CharacterDetailsScreen")
    }
}