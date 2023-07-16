package com.deepshooter.composeclock.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp


@Composable
fun ClockSphere(
    modifier: Modifier = Modifier,
) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val clockRadius = 0.9f * size.minDimension / 2f
        drawCircle(
            color = Color.White.copy(alpha = 0.5f),
            radius = clockRadius,
            style = Stroke(
                width = 3.dp.toPx()
            ),
        )
    }
}