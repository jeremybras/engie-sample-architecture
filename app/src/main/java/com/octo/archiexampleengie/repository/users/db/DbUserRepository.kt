package com.octo.archiexampleengie.repository.users.db

import com.octo.archiexampleengie.core.users.User
import com.octo.archiexampleengie.core.users.UserRepository

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
            siteAdmin = entity.siteAdmin ?: false
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
        siteAdmin = entity.siteAdmin
    )
}
