package com.octo.archiexampleengie.core.users

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.only
import com.nhaarman.mockito_kotlin.then
import com.octo.archiexampleengie.Fixtures
import com.octo.archiexampleengie.android.users.UserPresenter
import com.octo.archiexampleengie.repository.RepositoryException
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserInteractorTest {

    @Mock private lateinit var presenter: UserPresenter
    @Mock private lateinit var dbRepository: UserRepository
    @Mock private lateinit var apiRepository: UserRepository
    private lateinit var interactor: UserInteractor

    @Before
    fun setUp() {
        interactor = UserInteractor(presenter, dbRepository, apiRepository)
    }

    @Test
    fun `loadUsers() should return an ordered list from the database`() {
        // GIVEN
        val user1 = Fixtures.user().copy(id = 150)
        val user2 = Fixtures.user().copy(id = 50)
        given(dbRepository.getUsers()).willReturn(listOf(user1, user2))

        // WHEN
        interactor.loadUsers()

        // THEN
        then(dbRepository).should(only()).getUsers()
        then(presenter).should(only()).presentUsers(listOf(user2, user1))
    }

    @Test
    fun `loadUsers() should load, store, sort, and return an ordererd list from the webs`() {
        // GIVEN
        val user1 = Fixtures.user().copy(id = 150)
        val user2 = Fixtures.user().copy(id = 50)
        given(dbRepository.getUsers()).willReturn(emptyList())
        given(apiRepository.getUsers()).willReturn(listOf(user1, user2))

        // WHEN
        interactor.loadUsers()

        // THEN
        then(dbRepository).should().getUsers()
        then(apiRepository).should(only()).getUsers()
        then(dbRepository).should().addAll(listOf(user1, user2))
        then(presenter).should(only()).presentUsers(listOf(user2, user1))
    }

    @Test
    fun `loadUsers() should call presentError when no user is found`() {
        // GIVEN
        given(dbRepository.getUsers()).willReturn(emptyList())
        given(apiRepository.getUsers()).willReturn(emptyList())

        // WHEN
        interactor.loadUsers()

        // THEN
        then(dbRepository).should(only()).getUsers()
        then(apiRepository).should(only()).getUsers()
        then(presenter).should(only()).presentError()
    }

    @Test
    fun `loadUsers() should call presentError when RepositoryException is thrown`() {
        // GIVEN
        given(dbRepository.getUsers()).willThrow(RepositoryException::class.java)

        // WHEN
        interactor.loadUsers()

        // THEN
        then(presenter).should(only()).presentError()
    }
}
