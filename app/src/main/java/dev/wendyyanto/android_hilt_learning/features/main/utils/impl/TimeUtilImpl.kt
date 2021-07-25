package dev.wendyyanto.android_hilt_learning.features.main.utils.impl

import android.util.Log
import dev.wendyyanto.android_hilt_learning.features.main.utils.contract.TimeUtil
import javax.inject.Inject

class TimeUtilImpl @Inject constructor(): TimeUtil {

    init {
        Log.v("DaggerHilt", "TimeUtilImpl")
    }

    override fun getCurrentTime(): Long {
        return System.currentTimeMillis()
    }
}