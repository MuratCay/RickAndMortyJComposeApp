package com.muratcay.rickandmortyjcomposeapp.feature.all_episodes

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
internal fun AllEpisodesRoute(
    modifier: Modifier = Modifier,
    viewModel: AllEpisodesViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    AllEpisodesScreen(modifier = modifier, allEpisodesUiState = uiState.value)
}

@Composable
fun AllEpisodesScreen(
    modifier: Modifier = Modifier,
    allEpisodesUiState: AllEpisodesUiState
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "AllEpisodesScreen")
    }
}