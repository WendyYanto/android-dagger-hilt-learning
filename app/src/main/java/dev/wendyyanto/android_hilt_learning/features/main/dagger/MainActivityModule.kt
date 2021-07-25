package dev.wendyyanto.android_hilt_learning.features.main.dagger

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dev.wendyyanto.android_hilt_learning.features.main.utils.contract.TimeUtil
import dev.wendyyanto.android_hilt_learning.features.main.utils.impl.TimeUtilImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class MainActivityModule {

    @Binds
    @ActivityRetainedScoped
    abstract fun bindsTimeUtil(timeUtilImpl: TimeUtilImpl): TimeUtil
}