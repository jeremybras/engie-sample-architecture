package com.octo.archiexampleengie.repository.workorders.api

import com.octo.archiexampleengie.core.workorder.User
import com.octo.archiexampleengie.core.workorder.UserRepository
import com.octo.archiexampleengie.repository.RepositoryException
import java.io.IOException

class ApiUserRepository(private val service: UserService) : UserRepository {

    @Throws(RepositoryException::class)
    override fun getUsers(): List<User> {
        try {
            val body = service.getUsers(1325).execute().body()
            if (body != null) {
                return transformToEntity(body)
            } else {
                throw RepositoryException()
            }
        } catch (io: IOException) {
            throw RepositoryException(cause = io)
        }
    }

    @Throws(RepositoryException::class)
    override fun get(login: String): User {
        try {
            val body = service.getUser(login).execute().body()
            if (body != null) {
                return transformToEntity(body)
            } else {
                throw RepositoryException()
            }
        } catch (io: IOException) {
            throw RepositoryException(cause = io)
        }
    }

    private fun transformToEntity(response: List<UserJSON>): List<User> =
        response.map { transformToEntity(it) }

    private fun transformToEntity(user: UserJSON): User = User(
        login = user.login,
        id = user.id,
        node_id = user.node_id ?: "",
        avatarUrl = user.avatar_url ?: "",
        gravatarId = user.gravatar_id ?: "",
        url = user.url ?: "",
        htmlUrl = user.html_url ?: "",
        followersUrl = user.followers_url ?: "",
        followingUrl = user.following_url ?: "",
        gistsUrl = user.gists_url ?: "",
        starredUrl = user.starred_url ?: "",
        subscriptionsUrl = user.subscriptions_url ?: "",
        organizationsUrl = user.organizations_url ?: "",
        reposUrl = user.repos_url ?: "",
        eventsUrl = user.events_url ?: "",
        received_eventsUrl = user.received_events_url ?: "",
        type = user.type ?: "",
        siteAdmin = user.site_admin ?: false,
        name = user.name ?: "",
        company = user.company ?: "",
        blog = user.blog ?: "",
        location = user.location ?: "",
        email = user.email ?: "",
        hireable = user.hireable ?: "",
        bio = user.bio ?: "",
        publicRepos = user.public_repos ?: 0,
        publicGists = user.public_gists ?: 0,
        followers = user.followers ?: 0,
        following = user.following ?: 0,
        createdAt = user.created_at,
        updatedAt = user.updated_at
    )

    override fun removeAll() {
        throw RepositoryException("Not supported")
    }

    override fun addAll(users: List<User>) {
        throw RepositoryException("Not supported")
    }
}
