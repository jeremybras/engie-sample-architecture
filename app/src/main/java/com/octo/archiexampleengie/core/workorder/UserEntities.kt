package com.octo.archiexampleengie.core.workorder

import org.threeten.bp.ZonedDateTime

data class User(
    val login: String,
    val id: Int,
    val node_id: String,
    val avatarUrl: String,
    val gravatarId: String,
    val url: String,
    val htmlUrl: String,
    val followersUrl: String,
    val followingUrl: String,
    val gistsUrl: String,
    val starredUrl: String,
    val subscriptionsUrl: String,
    val organizationsUrl: String,
    val reposUrl: String,
    val eventsUrl: String,
    val received_eventsUrl: String,
    val type: String,
    val siteAdmin: Boolean,
    val name: String,
    val company: String,
    val blog: String,
    val location: String,
    val email: String?,
    val hireable: String?,
    val bio: String?,
    val publicRepos: Int,
    val publicGists: Int,
    val followers: Int,
    val following: Int,
    val createdAt: ZonedDateTime?,
    val updatedAt: ZonedDateTime?
)
