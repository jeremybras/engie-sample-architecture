package com.octo.archiexampleengie.android

import com.octo.archiexampleengie.android.users.RoadmapComponent
import com.octo.archiexampleengie.android.users.UserModule
import dagger.Component
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class, NetworkModule::class, DatabaseModule::class])
interface MainComponent {
    fun plus(module: UserModule): RoadmapComponent
    fun moshiConverter(): MoshiConverterFactory // For integration tests
}
