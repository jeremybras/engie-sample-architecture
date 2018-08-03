package com.octo.archiexampleengie.repository.users.api

import com.nhaarman.mockito_kotlin.mock
import com.octo.archiexampleengie.android.DaggerMainComponent
import com.octo.archiexampleengie.android.MainModule
import com.octo.archiexampleengie.core.users.User
import com.octo.archiexampleengie.repository.RepositoryException
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.Buffer
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit

class ApiUserRepositoryTest {

    private val mockWebServer = MockWebServer()
    private lateinit var repository: ApiUserRepository

    @Before
    fun setUp() {
        val moshiConverter = DaggerMainComponent.builder()
            .mainModule(MainModule(mock()))
            .build()
            .moshiConverter()

        val retrofit = Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(moshiConverter)
            .build()

        repository = ApiUserRepository(retrofit.create(UserService::class.java))
    }

    @Test
    fun `getUsers() should return a users list`() {
        // GIVEN
        val inputStream = javaClass.classLoader.getResourceAsStream("users.json")
        mockWebServer.enqueue(
            MockResponse().setResponseCode(200).setBody(Buffer().readFrom(inputStream))
        )

        // WHEN
        val entities = repository.getUsers()

        // THEN
        val expected = User(
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
        assertThat(entities.size).isEqualTo(30)
        assertThat(entities.first()).isEqualTo(expected)
    }

    @Test(expected = RepositoryException::class)
    fun `getUsers() should throw exception`() {
        // GIVEN
        mockWebServer.enqueue(MockResponse().setResponseCode(404))

        // WHEN
        repository.getUsers()
    }

}
