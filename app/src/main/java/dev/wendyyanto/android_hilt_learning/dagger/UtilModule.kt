package dev.wendyyanto.android_hilt_learning.dagger

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dev.wendyyanto.android_hilt_learning.utils.contract.TimeUtil
import dev.wendyyanto.android_hilt_learning.utils.impl.TimeUtilImpl

@Module
@InstallIn(ActivityComponent::class)
abstract class UtilModule {

    @Binds
    abstract fun bindsTimeUtil(timeUtilImpl: TimeUtilImpl): TimeUtil
}