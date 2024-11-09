package com.muratcay.rickandmortyjcomposeapp.feature.character_details.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.muratcay.rickandmortyjcomposeapp.feature.character_details.CharacterDetailsRoute

const val CharacterDetailsNavigationRoute = "character_details_route"

fun NavController.navigateToCharacterDetails(
    navOptions: NavOptions? = null
) {
    this.navigate(CharacterDetailsNavigationRoute, navOptions)
}

fun NavGraphBuilder.characterDetailsScreen() {
    composable(route = CharacterDetailsNavigationRoute) {
        CharacterDetailsRoute()
    }
}