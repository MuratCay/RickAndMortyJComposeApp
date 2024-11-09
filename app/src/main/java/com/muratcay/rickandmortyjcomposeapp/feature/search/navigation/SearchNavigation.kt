package com.muratcay.rickandmortyjcomposeapp.feature.search.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.muratcay.rickandmortyjcomposeapp.feature.search.SearchRoute

const val SearchNavigationRoute = "search_route"

fun NavController.navigateToSearch(
    navOptions: NavOptions? = null
) {
    this.navigate(SearchNavigationRoute, navOptions)
}

fun NavGraphBuilder.searchScreen() {
    composable(route = SearchNavigationRoute) {
        SearchRoute()
    }
}