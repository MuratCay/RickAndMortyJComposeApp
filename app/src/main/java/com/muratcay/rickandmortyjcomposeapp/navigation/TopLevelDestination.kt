package com.muratcay.rickandmortyjcomposeapp.navigation

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.muratcay.rickandmortyjcomposeapp.R
import com.muratcay.rickandmortyjcomposeapp.feature.all_episodes.navigation.AllEpisodesNavigationRoute
import com.muratcay.rickandmortyjcomposeapp.feature.home.navigation.HomeNavigationRoute
import com.muratcay.rickandmortyjcomposeapp.feature.search.navigation.SearchNavigationRoute

enum class TopLevelDestination(
    val route: String, val selectedIcon: Icon, val unSelectedIcon: Icon, val titleTextId: Int
) {
    HOME(
        route = HomeNavigationRoute,
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Home),
        unSelectedIcon = Icon.ImageVectorIcon(AppIcons.Home),
        titleTextId = R.string.home_title
    ),
    EPISODES(
        route = AllEpisodesNavigationRoute,
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Episode),
        unSelectedIcon = Icon.ImageVectorIcon(AppIcons.Episode),
        titleTextId = R.string.episodes
    ),
    SEARCH(
        route = SearchNavigationRoute,
        selectedIcon = Icon.ImageVectorIcon(AppIcons.Search),
        unSelectedIcon = Icon.ImageVectorIcon(AppIcons.Search),
        titleTextId = R.string.search
    )
}

sealed class Icon {
    data class ImageVectorIcon(val imageVector: ImageVector) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}

object AppIcons {
    val Home = Icons.Rounded.Home
    val Episode = Icons.Rounded.PlayArrow
    val Search = Icons.Rounded.Search
}