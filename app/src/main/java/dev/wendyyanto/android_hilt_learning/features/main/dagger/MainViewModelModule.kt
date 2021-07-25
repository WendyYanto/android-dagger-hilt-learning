package dev.wendyyanto.android_hilt_learning.features.main.dagger

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dev.wendyyanto.android_hilt_learning.data.local.contract.UserLocalRepository
import dev.wendyyanto.android_hilt_learning.data.local.impl.UserLocalRepositoryImpl
import dev.wendyyanto.android_hilt_learning.validator.contract.UserValidator
import dev.wendyyanto.android_hilt_learning.validator.impl.UserValidatorImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class MainViewModelModule {

    @Binds
    abstract fun bindsUserValidator(userValidatorImpl: UserValidatorImpl): UserValidator

    @Binds
    abstract fun bindsUserLocalRepository(userLocalRepositoryImpl: UserLocalRepositoryImpl): UserLocalRepository
}