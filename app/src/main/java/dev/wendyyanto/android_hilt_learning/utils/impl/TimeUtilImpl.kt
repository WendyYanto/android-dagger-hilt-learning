package dev.wendyyanto.android_hilt_learning.utils.impl

import dev.wendyyanto.android_hilt_learning.utils.contract.TimeUtil
import javax.inject.Inject

class TimeUtilImpl @Inject constructor(): TimeUtil {

    override fun getCurrentTime(): Long {
        return System.currentTimeMillis()
    }
}