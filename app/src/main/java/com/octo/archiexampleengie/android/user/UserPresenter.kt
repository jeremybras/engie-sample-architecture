package com.octo.archiexampleengie.android.user

import com.octo.archiexampleengie.R
import com.octo.archiexampleengie.android.common.DateFormatter
import com.octo.archiexampleengie.core.workorder.User
import org.threeten.bp.ZonedDateTime

class UserPresenter(
    private val view: UserView,
    private val dateFormatter: DateFormatter
) {
    fun presentError() {
        view.showError(R.string.repository_exception)
    }

    fun presentUsers(users: List<User>) {
        view.showUsers(users.map { transformUser(it) })
    }

    private fun transformUser(user: User): UserDisplayModel = UserDisplayModel(
        login = user.login,
        id = user.id.toString(),
        name = user.name,
        createdDate = transformDate(user.createdAt),
        updatedDate = transformDate(user.updatedAt),
        reposNb = user.publicRepos.toString(),
        gistsNb = user.publicGists.toString(),
        followersNb = user.followers.toString(),
        followingNb = user.following.toString()
    )

    private fun transformDate(date: ZonedDateTime?): String {
        return if (date != null) {
            dateFormatter.formatDate(date)
        } else {
            ""
        }
    }
}
