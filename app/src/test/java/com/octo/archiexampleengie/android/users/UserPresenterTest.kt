package com.octo.archiexampleengie.android.users

import com.nhaarman.mockito_kotlin.only
import com.nhaarman.mockito_kotlin.then
import com.octo.archiexampleengie.Fixtures
import com.octo.archiexampleengie.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserPresenterTest {

    @Mock private lateinit var view: UserView
    private lateinit var presenter: UserPresenter

    @Before
    fun setUp() {
        presenter = UserPresenter(view)
    }

    @Test
    fun `presentUsers() should showUsers`() {
        val user = Fixtures.user()

        // WHEN
        presenter.presentUsers(listOf(user))

        // THEN
        then(view).should(only()).showUsers(listOf(UserDisplayModel(
            login = "#1236 creiht",
            id = "1236"
        )))
    }

    @Test
    fun `presentError() should show error`() {
        // WHEN
        presenter.presentError()

        // THEN
        then(view).should(only()).showError(R.string.repository_exception)
    }
}
