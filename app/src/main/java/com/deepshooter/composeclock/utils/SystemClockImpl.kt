package com.deepshooter.composeclock.utils

class SystemClockImpl : SystemClock {
    override fun currentTimeMillis(): Long = System.currentTimeMillis()
}