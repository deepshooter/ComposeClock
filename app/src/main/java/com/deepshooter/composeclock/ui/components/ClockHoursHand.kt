package com.deepshooter.composeclock.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.deepshooter.composeclock.models.ParticlesModel
import com.deepshooter.composeclock.models.create
import com.deepshooter.composeclock.models.next
import com.deepshooter.composeclock.utils.LocalRandom
import com.deepshooter.composeclock.utils.LocalSystemClock
import com.deepshooter.composeclock.utils.drawParticles
import com.deepshooter.composeclock.utils.toHourRadians

@Composable
fun ClockHoursHand(
    modifier: Modifier = Modifier,
) {
    val random = LocalRandom.current
    val systemClock = LocalSystemClock.current
    var particlesModel by remember {
        mutableStateOf(
            ParticlesModel.create(
                random = random,
                style = ParticlesModel.Style.HourHand,
                angleOffset = systemClock
                    .currentTimeMillis()
                    .toHourRadians(systemClock),
            )

        )
    }
    FrameEffect(Unit) { period ->
        particlesModel =
            particlesModel.next(
                random = random,
                period = period,
                angleOffset = systemClock
                    .currentTimeMillis()
                    .toHourRadians(systemClock)
            )
    }
    Canvas(modifier = modifier.fillMaxSize()) {
        drawParticles(particlesModel)
    }
}