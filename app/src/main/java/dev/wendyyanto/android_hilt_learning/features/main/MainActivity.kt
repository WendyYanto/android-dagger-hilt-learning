package dev.wendyyanto.android_hilt_learning.features.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import dev.wendyyanto.android_hilt_learning.databinding.ActivityMainBinding
import dev.wendyyanto.android_hilt_learning.utils.contract.TimeUtil
import dev.wendyyanto.android_hilt_learning.validator.contract.UserValidator
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var timeUtil: dagger.Lazy<TimeUtil>

    @Inject
    lateinit var userValidator: dagger.Lazy<UserValidator>

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.tvHelloWorld.setOnClickListener {
            Toast.makeText(this, "Generated from timeUtil: ${timeUtil.get().getCurrentTime()}", Toast.LENGTH_SHORT).show()
        }

        viewBinding.bSubmit.setOnClickListener {
            submitUser()
        }
    }

    private fun submitUser() {
        val name = viewBinding.aetName.text.toString()
        val password = viewBinding.aetPassword.text.toString()

        if (userValidator.get().isUserValid(name, password)) {
            // Go To Next Pagee
            return
        }

        Toast.makeText(this, "Some fields are empty !", Toast.LENGTH_SHORT).show()
    }
}