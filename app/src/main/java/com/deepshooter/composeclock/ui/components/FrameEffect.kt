package com.deepshooter.composeclock.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.isActive
import java.util.concurrent.TimeUnit


@Composable
fun FrameEffect(
    key1: Any?,
    block: (period: Long) -> Unit
) {
    LaunchedEffect(key1) {
        var lastFrame = 0L
        while (isActive) {
            val nextFrame = TimeUnit.NANOSECONDS.toMillis(awaitFrame())
            if (lastFrame != 0L) {
                val period = nextFrame - lastFrame
                block.invoke(period)
            }
            lastFrame = nextFrame
        }
    }
}
