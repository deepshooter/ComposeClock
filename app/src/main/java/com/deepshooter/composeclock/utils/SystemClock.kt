package com.deepshooter.composeclock.utils

import java.util.Calendar

interface SystemClock {

    fun currentTimeMillis(): Long

    fun getHour(): Int =
        Calendar.getInstance().get(Calendar.HOUR) % 12

}