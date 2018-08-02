package com.octo.archiexampleengie.android.user

import com.octo.archiexampleengie.android.FeatureScope
import com.octo.archiexampleengie.android.MainThreadExecutor
import com.octo.archiexampleengie.android.common.DateFormatter
import com.octo.archiexampleengie.core.workorder.UserInteractor
import com.octo.archiexampleengie.core.workorder.UserRepository
import com.octo.archiexampleengie.repository.common.db.EngieDatabase
import com.octo.archiexampleengie.repository.workorders.api.ApiUserRepository
import com.octo.archiexampleengie.repository.workorders.api.UserService
import com.octo.archiexampleengie.repository.workorders.db.DbUserRepository
import com.octo.workerdecorator.WorkerDecoration
import com.octo.workerdecorator.WorkerDecorator
import com.octo.workerdecorator.WorkerDecorator.decorate
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import java.util.concurrent.Executor
import javax.inject.Named

@Module
class UserModule {

    companion object {
        const val DB_REPOSITORY = "DB"
        const val API_REPOSITORY = "API"
    }

    @Provides
    fun provideUserViewModel(
        controller: UserController,
        decorator: WorkerDecoration<UserView>
    ): UserViewModel {
        val vm = UserViewModel(controller)
        decorator.setDecorated(vm)
        return vm
    }

    @Provides
    fun provideUserController(
        interactor: UserInteractor,
        executor: Executor
    ): UserController = decorate(UserControllerImpl(interactor), executor)

    @Provides
    fun provideUserInteractor(
        presenter: UserPresenter,
        @Named(DB_REPOSITORY) dbRepository: UserRepository,
        @Named(API_REPOSITORY) apiRepository: UserRepository
    ): UserInteractor =
        UserInteractor(presenter, dbRepository, apiRepository)


    @Provides
    fun provideUserPresenter(
        userView: UserView,
        dateFormatter: DateFormatter
    ): UserPresenter = UserPresenter(userView, dateFormatter)

    @Provides
    @FeatureScope
    fun provideUserViewDecorated(executor: MainThreadExecutor): WorkerDecoration<UserView> =
        WorkerDecorator.decorate(UserView::class.java, executor)

    @Provides
    fun provideUserView(decorator: WorkerDecoration<UserView>): UserView = decorator.asType()

    @Provides
    fun provideService(retrofit: Retrofit): UserService = retrofit.create(UserService::class.java)

    @Named(DB_REPOSITORY)
    @Provides
    fun provideUserDBRepository(db: EngieDatabase): UserRepository =
        DbUserRepository(db.userDao())

    @Named(API_REPOSITORY)
    @Provides
    fun provideUserApiRepository(
        userService: UserService
    ): UserRepository = ApiUserRepository(userService)
}
