package com.muratcay.rickandmortyjcomposeapp.navigation.appstate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.muratcay.rickandmortyjcomposeapp.feature.all_episodes.navigation.navigateToAllEpisodes
import com.muratcay.rickandmortyjcomposeapp.feature.home.navigation.HomeNavigationRoute
import com.muratcay.rickandmortyjcomposeapp.feature.home.navigation.navigateToHome
import com.muratcay.rickandmortyjcomposeapp.feature.search.navigation.navigateToSearch
import com.muratcay.rickandmortyjcomposeapp.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberMainAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): MainAppState {
    return remember(navController, coroutineScope) {
        MainAppState(navController, coroutineScope)
    }
}

@Stable
class MainAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val shouldShowBottomBar: Boolean
        @Composable get() = currentDestination?.hierarchy?.any { destination ->
            topLevelDestinations.any {
                destination.route?.contains(it.route) ?: false
            }
        } ?: false

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().toList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelOptions = navOptions {
            popUpTo(HomeNavigationRoute) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.HOME -> navController.navigateToHome(topLevelOptions)
            TopLevelDestination.EPISODES -> navController.navigateToAllEpisodes(topLevelOptions)
            TopLevelDestination.SEARCH -> navController.navigateToSearch(topLevelOptions)
        }
    }

    fun onBackPress() {
        navController.popBackStack()
    }
}