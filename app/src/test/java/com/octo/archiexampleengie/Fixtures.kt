package com.octo.archiexampleengie

import com.octo.archiexampleengie.core.users.User

object Fixtures {
    fun user(): User = User(
        login = "creiht",
        id = 1236,
        node_id = "MDQ6VXNlcjEyMzY=",
        avatarUrl = "https://avatars0.githubusercontent.com/u/1236?v=4",
        gravatarId = "",
        url = "https://api.github.com/users/creiht",
        htmlUrl = "https://github.com/creiht",
        followersUrl = "https://api.github.com/users/creiht/followers",
        followingUrl = "https://api.github.com/users/creiht/following{/other_user}",
        gistsUrl = "https://api.github.com/users/creiht/gists{/gist_id}",
        starredUrl = "https://api.github.com/users/creiht/starred{/owner}{/repo}",
        subscriptionsUrl = "https://api.github.com/users/creiht/subscriptions",
        organizationsUrl = "https://api.github.com/users/creiht/orgs",
        reposUrl = "https://api.github.com/users/creiht/repos",
        eventsUrl = "https://api.github.com/users/creiht/events{/privacy}",
        received_eventsUrl = "https://api.github.com/users/creiht/received_events",
        type = "User",
        siteAdmin = false
    )
}
