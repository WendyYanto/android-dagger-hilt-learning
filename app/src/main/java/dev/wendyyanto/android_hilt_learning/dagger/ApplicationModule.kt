package dev.wendyyanto.android_hilt_learning.dagger

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    private companion object {
        const val USER = "USER"
    }

    @Provides
    @Singleton
    @Named("UserSharedPreference")
    fun provideUserSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(USER, Context.MODE_PRIVATE)
    }
}