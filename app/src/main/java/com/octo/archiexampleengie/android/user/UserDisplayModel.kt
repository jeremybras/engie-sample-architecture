package com.octo.archiexampleengie.android.user

data class UserDisplayModel(
    val login: String,
    val id: String,
    val name: String,
    val createdDate: String,
    val updatedDate: String,
    val reposNb: String,
    val gistsNb: String,
    val followersNb: String,
    val followingNb: String
)
