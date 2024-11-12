package com.muratcay.rickandmortyjcomposeapp.data.model

import com.google.gson.annotations.SerializedName
import com.muratcay.rickandmortyjcomposeapp.domain.model.CharacterPage

data class RemoteCharacterPage(
    @SerializedName("info")
    val remoteInfo: RemoteInfo,
    @SerializedName("results")
    val remoteCharacters: List<RemoteCharacter>
) {
    data class RemoteInfo(
        @SerializedName("count")
        val count: Int,
        @SerializedName("next")
        val next: String,
        @SerializedName("pages")
        val pages: Int,
        @SerializedName("prev")
        val prev: Any
    )
}

fun RemoteCharacterPage.toDomainCharacterPage(): CharacterPage {
    return CharacterPage(
        info = CharacterPage.Info(
            count = remoteInfo.count,
            pages = remoteInfo.pages,
            next = remoteInfo.next,
            prev = remoteInfo.next
        ),
        characters = remoteCharacters.map { it.toDomainCharacter() }
    )
}