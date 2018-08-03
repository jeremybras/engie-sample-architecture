package com.octo.archiexampleengie.android.users

import com.octo.archiexampleengie.android.FeatureScope
import dagger.Subcomponent

@FeatureScope
@Subcomponent(modules = [UserModule::class])
interface RoadmapComponent {
    fun inject(userActivity: UserActivity)
}
