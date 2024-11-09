package com.muratcay.rickandmortyjcomposeapp.feature.character_episode.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.muratcay.rickandmortyjcomposeapp.feature.character_episode.CharacterEpisodeRoute

const val CharacterEpisodeNavigationRoute = "character_episode_route"

fun NavController.navigateToCharacterEpisode(
    navOptions: NavOptions? = null
) {
    this.navigate(CharacterEpisodeNavigationRoute, navOptions)
}

fun NavGraphBuilder.characterEpisodeScreen() {
    composable(route = CharacterEpisodeNavigationRoute) {
        CharacterEpisodeRoute()
    }
}