package com.octo.archiexampleengie.android

import com.octo.archiexampleengie.android.user.RoadmapComponent
import com.octo.archiexampleengie.android.user.UserModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class, NetworkModule::class, DatabaseModule::class])
interface MainComponent {
    fun plus(module: UserModule): RoadmapComponent
}
