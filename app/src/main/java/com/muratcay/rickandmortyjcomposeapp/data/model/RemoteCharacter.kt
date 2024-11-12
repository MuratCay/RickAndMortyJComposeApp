package com.muratcay.rickandmortyjcomposeapp.data.model

import com.google.gson.annotations.SerializedName
import com.muratcay.rickandmortyjcomposeapp.domain.model.CharacterGender
import com.muratcay.rickandmortyjcomposeapp.domain.model.CharacterStatus
import com.muratcay.rickandmortyjcomposeapp.domain.model.Character

data class RemoteCharacter(
    @SerializedName("created")
    val created: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("location")
    val remoteLocation: RemoteLocation,
    @SerializedName("name")
    val name: String,
    @SerializedName("origin")
    val remoteOrigin: RemoteOrigin,
    @SerializedName("species")
    val species: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
) {
    data class RemoteLocation(
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
    )

    data class RemoteOrigin(
        @SerializedName("name")
        val name: String,
        @SerializedName("url")
        val url: String
    )
}

fun RemoteCharacter.toDomainCharacter(): Character {
    val characterGender = when (gender.lowercase()) {
        "female" -> CharacterGender.Female
        "male" -> CharacterGender.Male
        "genderless" -> CharacterGender.Genderless
        else -> CharacterGender.Unknown
    }
    val characterStatus = when (status.lowercase()) {
        "alive" -> CharacterStatus.Alive
        "dead" -> CharacterStatus.Dead
        else -> CharacterStatus.Unknown
    }
    return Character(
        created = created,
        episodeIds = episode.map { it.substring(it.lastIndexOf("/") + 1).toInt() },
        gender = characterGender,
        id = id,
        imageUrl = image,
        location = Character.Location(name = remoteLocation.name, url = remoteLocation.url),
        name = name,
        origin = Character.Origin(name = remoteOrigin.name, url = remoteOrigin.url),
        species = species,
        status = characterStatus,
        type = type
    )
}