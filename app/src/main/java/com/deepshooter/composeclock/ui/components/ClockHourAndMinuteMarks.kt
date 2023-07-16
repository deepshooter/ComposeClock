package com.deepshooter.composeclock.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.deepshooter.composeclock.utils.PI
import com.deepshooter.composeclock.utils.PI_DIV_2
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ClockHourAndMinuteMarks(
    modifier: Modifier = Modifier,
) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val hourMarkStyle = Fill
        val minuteMarkStyle = Stroke(width = 1.dp.toPx())
        val hourMarkRadius = 5.dp.toPx()
        val minuteMarkRadius = 2.dp.toPx()
        repeat(60) {
            val clockRadius = 0.95f * size.minDimension / 2f
            val initialDegrees = -PI_DIV_2
            val secondsToRadians = PI / 30f
            val degree = initialDegrees + it * secondsToRadians
            val x = center.x + cos(degree) * clockRadius
            val y = center.y + sin(degree) * clockRadius
            val isHourMark = it % 5 == 0
            val style = if (isHourMark) hourMarkStyle else minuteMarkStyle
            val radius = if (isHourMark) hourMarkRadius else minuteMarkRadius
            drawCircle(
                color = Color.White,
                radius = radius,
                style = style,
                center = Offset(x, y)
            )
        }
    }
}