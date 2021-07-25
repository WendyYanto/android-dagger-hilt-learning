package dev.wendyyanto.android_hilt_learning.validator.contract

interface UserValidator {

    fun isUserValid(name: String, password: String): Boolean
}