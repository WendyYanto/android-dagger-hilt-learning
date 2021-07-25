package dev.wendyyanto.android_hilt_learning.data.local.impl

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import dev.wendyyanto.android_hilt_learning.data.local.contract.UserLocalRepository
import javax.inject.Inject
import javax.inject.Named

class UserLocalRepositoryImpl @Inject constructor(
    @Named("UserSharedPreference")
    private val sharedPreferences: SharedPreferences): UserLocalRepository {

    init {
        Log.v("DaggerHilt", "UserLocalRepositoryImpl")
    }

    override fun saveUser(name: String, password: String) {
        sharedPreferences.edit {
            putString("name", name)
            putString("password", password)
            putBoolean("isLoggedIn", true)
        }
    }

    override fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }
}