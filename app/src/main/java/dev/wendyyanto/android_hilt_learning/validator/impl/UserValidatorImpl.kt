package dev.wendyyanto.android_hilt_learning.validator.impl

import android.util.Log
import dev.wendyyanto.android_hilt_learning.validator.contract.UserValidator
import javax.inject.Inject

class UserValidatorImpl @Inject constructor(): UserValidator {

    init {
        Log.v("DaggerHilt", "UserValidatorImpl")
    }

    override fun isUserValid(name: String, password: String): Boolean {
        return isNameValid(name) && isPasswordValid(password)
    }

    private fun isNameValid(name: String): Boolean {
        return name.isNotBlank()
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.isNotBlank()
    }
}