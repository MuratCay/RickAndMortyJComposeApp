package com.muratcay.rickandmortyjcomposeapp.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.muratcay.rickandmortyjcomposeapp.feature.home.HomeRoute

const val HomeNavigationRoute = "home_route"

fun NavController.navigateToHome(
    navOptions: NavOptions? = null
) {
    this.navigate(HomeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable(route = HomeNavigationRoute) {
        HomeRoute()
    }
}