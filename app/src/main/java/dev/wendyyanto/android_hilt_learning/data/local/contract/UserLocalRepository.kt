package dev.wendyyanto.android_hilt_learning.data.local.contract

interface UserLocalRepository {

    fun saveUser(name: String, password: String)

    fun isLoggedIn(): Boolean
}