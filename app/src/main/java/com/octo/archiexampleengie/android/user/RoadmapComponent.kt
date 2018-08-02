package com.octo.archiexampleengie.android.user

import com.octo.archiexampleengie.android.FeatureScope
import dagger.Subcomponent

@FeatureScope
@Subcomponent(modules = [UserModule::class])
interface RoadmapComponent {
    fun inject(userActivity: UserActivity)
}
