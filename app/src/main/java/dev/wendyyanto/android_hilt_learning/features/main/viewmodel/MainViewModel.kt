package dev.wendyyanto.android_hilt_learning.features.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.wendyyanto.android_hilt_learning.validator.contract.UserValidator
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userValidator: UserValidator): ViewModel() {

    val isUserValid: LiveData<Boolean>
        get() = _isUserValid

    private val _isUserValid = MutableLiveData<Boolean>()

    fun validateUser(name: String, password: String) {
        _isUserValid.value = userValidator.isUserValid(name, password)
    }
}
