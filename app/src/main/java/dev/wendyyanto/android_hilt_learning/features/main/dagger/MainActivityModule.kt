package dev.wendyyanto.android_hilt_learning.features.main.dagger

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dev.wendyyanto.android_hilt_learning.features.main.utils.contract.TimeUtil
import dev.wendyyanto.android_hilt_learning.features.main.utils.impl.TimeUtilImpl

@Module
@InstallIn(ActivityComponent::class)
abstract class MainActivityModule {

    @Binds
    abstract fun bindsTimeUtil(timeUtilImpl: TimeUtilImpl): TimeUtil
}