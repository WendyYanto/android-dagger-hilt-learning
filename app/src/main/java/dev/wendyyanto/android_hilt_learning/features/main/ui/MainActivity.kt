package dev.wendyyanto.android_hilt_learning.features.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import dev.wendyyanto.android_hilt_learning.databinding.ActivityMainBinding
import dev.wendyyanto.android_hilt_learning.features.main.viewmodel.MainViewModel
import dev.wendyyanto.android_hilt_learning.utils.contract.TimeUtil
import dev.wendyyanto.android_hilt_learning.validator.contract.UserValidator
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var timeUtil: dagger.Lazy<TimeUtil>

    private val viewModel: MainViewModel by viewModels()

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setupObserver()
        setupInteraction()
    }

    private fun setupObserver() {
        viewModel.isUserValid.observe(this, Observer { value ->
            if (value) {
                Toast.makeText(this, "Name or password is valid", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Name or password is invalid", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupInteraction() {
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

        viewModel.validateUser(name, password)
    }
}