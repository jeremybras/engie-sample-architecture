package com.octo.archiexampleengie.repository.workorders.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.threeten.bp.ZonedDateTime

@Entity
data class UserDb(
    @PrimaryKey var login: String,
    var id: Int,
    var node_id: String? = null,
    var avatarUrl: String? = null,
    var gravatarId: String? = null,
    var url: String? = null,
    var htmlUrl: String? = null,
    var followersUrl: String? = null,
    var followingUrl: String? = null,
    var gistsUrl: String? = null,
    var starredUrl: String? = null,
    var subscriptionsUrl: String? = null,
    var organizationsUrl: String? = null,
    var reposUrl: String? = null,
    var eventsUrl: String? = null,
    var received_eventsUrl: String? = null,
    var type: String? = null,
    var siteAdmin: Boolean? = null,
    var name: String? = null,
    var company: String? = null,
    var blog: String? = null,
    var location: String? = null,
    var email: String?? = null,
    var hireable: String?? = null,
    var bio: String?? = null,
    var publicRepos: Int? = null,
    var publicGists: Int? = null,
    var followers: Int? = null,
    var following: Int? = null,
    var createdAt: ZonedDateTime?,
    var updatedAt: ZonedDateTime?
)
