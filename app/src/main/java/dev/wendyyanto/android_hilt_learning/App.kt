package dev.wendyyanto.android_hilt_learning

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.v("DaggerHilt", "App")
    }
}