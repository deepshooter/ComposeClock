package com.deepshooter.composeclock.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.deepshooter.composeclock.models.SecondModel
import com.deepshooter.composeclock.models.create
import com.deepshooter.composeclock.models.next
import com.deepshooter.composeclock.utils.LocalSystemClock
import com.deepshooter.composeclock.utils.PI
import com.deepshooter.composeclock.utils.PI_DIV_2
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ClockSecondsHand(
    modifier: Modifier = Modifier,
) {
    val systemClock = LocalSystemClock.current
    var secondModel by remember { mutableStateOf(SecondModel.create(systemClock)) }
    FrameEffect(Unit) { period ->
        secondModel = secondModel.next(period)
    }
    Canvas(modifier = modifier.fillMaxSize()) {
        val interpolator = FastOutSlowInEasing
        val animatedSecond = secondModel.state.seconds +
                interpolator.transform((secondModel.state.millis % 1000) / 1000f)
        val initialDegrees = -PI_DIV_2
        val secondsToRadians = PI / 30f
        val degree = initialDegrees + animatedSecond * secondsToRadians
        val clockRadius = 0.9f * size.minDimension / 2f
        val x = center.x + cos(degree) * clockRadius
        val y = center.y + sin(degree) * clockRadius
        drawCircle(
            color = Color.White,
            radius = 4.dp.toPx(),
            center = Offset(x, y)
        )
    }
}