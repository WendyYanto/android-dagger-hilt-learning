package dev.wendyyanto.android_hilt_learning.features.main.utils.impl

import dev.wendyyanto.android_hilt_learning.features.main.utils.contract.TimeUtil
import javax.inject.Inject

class TimeUtilImpl @Inject constructor(): TimeUtil {

    override fun getCurrentTime(): Long {
        return System.currentTimeMillis()
    }
}