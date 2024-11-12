package com.muratcay.rickandmortyjcomposeapp.ui.base

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun BaseIcon(
    imageUrl: String?,
    placeholder: Int,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    size: Dp = IconSize,
) {
    val painter = if (imageUrl.isNullOrEmpty()) {
        painterResource(id = placeholder)
    } else {
        rememberAsyncImagePainter(model = imageUrl)
    }

    Icon(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier.size(size),
        tint = tint
    )
}

private val IconSize = 24.dp