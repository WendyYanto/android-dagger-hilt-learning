package dev.wendyyanto.android_hilt_learning.features.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import dev.wendyyanto.android_hilt_learning.databinding.ActivityMainBinding
import dev.wendyyanto.android_hilt_learning.features.main.viewmodel.MainViewModel
import dev.wendyyanto.android_hilt_learning.features.main.utils.contract.TimeUtil
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var timeUtil: TimeUtil

    private val viewModel: MainViewModel by viewModels()

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("DaggerHilt", "MainActivity")
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        setupObserver()
        setupInteraction()
    }

    private fun setupObserver() {
        viewModel.isUserValid.observe(this, Observer { value ->
            if (value) {
                viewModel.login(getName(), getPassword())
            } else {
                Toast.makeText(this, "Name or password is invalid", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.userSaved.observe(this, Observer {
            Toast.makeText(this, "User data saved", Toast.LENGTH_SHORT).show()
        })

        viewModel.isLoggedIn.observe(this, Observer {
            if (it) {
                Toast.makeText(this, "Is logged in", Toast.LENGTH_SHORT).show()
                viewBinding.aetName.isEnabled = false
                viewBinding.aetPassword.isEnabled = false
                viewBinding.bSubmit.visibility = View.GONE
            }
        })
    }

    private fun setupInteraction() {
        viewBinding.tvHelloWorld.setOnClickListener {
            Toast.makeText(this, "Generated from timeUtil: ${timeUtil.getCurrentTime()}", Toast.LENGTH_SHORT).show()
        }

        viewBinding.bSubmit.setOnClickListener {
            submitUser()
        }
    }

    private fun submitUser() {
        viewModel.validateUser(getName(), getPassword())
    }

    private fun getName() = viewBinding.aetName.text.toString()

    private fun getPassword() = viewBinding.aetPassword.text.toString()
}