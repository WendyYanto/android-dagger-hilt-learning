package dev.wendyyanto.android_hilt_learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import dev.wendyyanto.android_hilt_learning.utils.contract.TimeUtil
import dev.wendyyanto.android_hilt_learning.utils.impl.TimeUtilImpl
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var timeUtil: TimeUtil

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv_hello_world)

        textView.setOnClickListener {
            Toast.makeText(this, "Generated from timeUtil: ${timeUtil.getCurrentTime()}", Toast.LENGTH_SHORT).show()
        }
    }
}