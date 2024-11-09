package com.muratcay.rickandmortyjcomposeapp.feature.all_episodes.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.muratcay.rickandmortyjcomposeapp.feature.all_episodes.AllEpisodesRoute

const val AllEpisodesNavigationRoute = "all_episodes_route"

fun NavController.navigateToAllEpisodes(
    navOptions: NavOptions? = null
) {
    this.navigate(AllEpisodesNavigationRoute, navOptions)
}

fun NavGraphBuilder.allEpisodesScreen() {
    composable(route = AllEpisodesNavigationRoute) {
        AllEpisodesRoute()
    }
}