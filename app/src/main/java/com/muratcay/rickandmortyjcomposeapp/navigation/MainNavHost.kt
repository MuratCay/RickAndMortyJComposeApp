package com.muratcay.rickandmortyjcomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.muratcay.rickandmortyjcomposeapp.feature.all_episodes.navigation.allEpisodesScreen
import com.muratcay.rickandmortyjcomposeapp.feature.character_details.navigation.characterDetailsScreen
import com.muratcay.rickandmortyjcomposeapp.feature.character_episode.navigation.characterEpisodeScreen
import com.muratcay.rickandmortyjcomposeapp.feature.home.navigation.HomeNavigationRoute
import com.muratcay.rickandmortyjcomposeapp.feature.home.navigation.homeScreen
import com.muratcay.rickandmortyjcomposeapp.feature.search.navigation.searchScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = HomeNavigationRoute
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeScreen()
        allEpisodesScreen()
        searchScreen()
        characterEpisodeScreen()
        characterDetailsScreen()
    }
}