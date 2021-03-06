package dev.wendyyanto.android_hilt_learning.features.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.wendyyanto.android_hilt_learning.data.local.impl.UserLocalRepositoryImpl
import dev.wendyyanto.android_hilt_learning.validator.contract.UserValidator
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userValidator: UserValidator,
    private val userLocalRepository: UserLocalRepositoryImpl
) : ViewModel() {

    init {
        Log.v("DaggerHilt", "MainViewModel")
    }

    val isUserValid: LiveData<Boolean>
        get() = _isUserValid

    private val _isUserValid = MutableLiveData<Boolean>()

    val userSaved: LiveData<Boolean>
        get() = _userSaved

    private val _userSaved = MutableLiveData<Boolean>()

    val isLoggedIn: LiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value = userLocalRepository.isLoggedIn()
    }

    fun validateUser(name: String, password: String) {
        _isUserValid.value = userValidator.isUserValid(name, password)
    }

    fun login(name: String, password: String) {
        userLocalRepository.saveUser(name, password)
        _userSaved.value = true
    }
}
