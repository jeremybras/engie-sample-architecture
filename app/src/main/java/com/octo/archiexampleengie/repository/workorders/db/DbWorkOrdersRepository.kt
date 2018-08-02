package com.octo.archiexampleengie.repository.workorders.db

import com.octo.archiexampleengie.core.workorder.User
import com.octo.archiexampleengie.core.workorder.UserRepository

class DbUserRepository(private val dao: UserDao) : UserRepository {

    override fun getUsers(): List<User> = dao.getAll().map { transform(it) }

    override fun get(login: String): User = transform(dao.get(login))

    override fun removeAll() {
        dao.deleteAll()
    }

    override fun addAll(users: List<User>) {
        dao.addAll(users.map { transform(it) })
    }

    private fun transform(entity: UserDb): User {
        return User(
            login = entity.login,
            id = entity.id,
            node_id = entity.node_id ?: "",
            avatarUrl = entity.avatarUrl ?: "",
            gravatarId = entity.gravatarId ?: "",
            url = entity.url ?: "",
            htmlUrl = entity.htmlUrl ?: "",
            followersUrl = entity.followersUrl ?: "",
            followingUrl = entity.followingUrl ?: "",
            gistsUrl = entity.gistsUrl ?: "",
            starredUrl = entity.starredUrl ?: "",
            subscriptionsUrl = entity.subscriptionsUrl ?: "",
            organizationsUrl = entity.organizationsUrl ?: "",
            reposUrl = entity.reposUrl ?: "",
            eventsUrl = entity.eventsUrl ?: "",
            received_eventsUrl = entity.received_eventsUrl ?: "",
            type = entity.type ?: "",
            siteAdmin = entity.siteAdmin ?: false,
            name = entity.name ?: "",
            company = entity.company ?: "",
            blog = entity.blog ?: "",
            location = entity.location ?: "",
            email = entity.email ?: "",
            hireable = entity.hireable ?: "",
            bio = entity.bio ?: "",
            publicRepos = entity.publicRepos ?: 0,
            publicGists = entity.publicGists ?: 0,
            followers = entity.followers ?: 0,
            following = entity.following ?: 0,
            createdAt = entity.createdAt,
            updatedAt = entity.updatedAt
        )
    }

    private fun transform(entity: User): UserDb = UserDb(
        login = entity.login,
        id = entity.id,
        node_id = entity.node_id,
        avatarUrl = entity.avatarUrl,
        gravatarId = entity.gravatarId,
        url = entity.url,
        htmlUrl = entity.htmlUrl,
        followersUrl = entity.followersUrl,
        followingUrl = entity.followingUrl,
        gistsUrl = entity.gistsUrl,
        starredUrl = entity.starredUrl,
        subscriptionsUrl = entity.subscriptionsUrl,
        organizationsUrl = entity.organizationsUrl,
        reposUrl = entity.reposUrl,
        eventsUrl = entity.eventsUrl,
        received_eventsUrl = entity.received_eventsUrl,
        type = entity.type,
        siteAdmin = entity.siteAdmin,
        name = entity.name,
        company = entity.company,
        blog = entity.blog,
        location = entity.location,
        email = entity.email,
        hireable = entity.hireable,
        bio = entity.bio,
        publicRepos = entity.publicRepos,
        publicGists = entity.publicGists,
        followers = entity.followers,
        following = entity.following,
        createdAt = entity.createdAt,
        updatedAt = entity.updatedAt
    )
}
