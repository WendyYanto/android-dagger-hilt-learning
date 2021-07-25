package dev.wendyyanto.android_hilt_learning.dagger

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dev.wendyyanto.android_hilt_learning.validator.contract.UserValidator
import dev.wendyyanto.android_hilt_learning.validator.impl.UserValidatorImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class ValidatorModule {

    @Binds
    abstract fun bindsUserValidator(userValidatorImpl: UserValidatorImpl): UserValidator
}