package com.deepshooter.composeclock.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.deepshooter.composeclock.models.ParticlesModel
import com.deepshooter.composeclock.models.create
import com.deepshooter.composeclock.models.next
import com.deepshooter.composeclock.utils.LocalRandom
import com.deepshooter.composeclock.utils.drawParticles


@Composable
fun ClockParticles(
    modifier: Modifier = Modifier,
) {
    val random = LocalRandom.current
    var particlesModel by remember {
        mutableStateOf(
            ParticlesModel.create(
                style = ParticlesModel.Style.Background,
                random = random,
            )
        )
    }
    FrameEffect(Unit) { period ->
        particlesModel = particlesModel.next(
            random = random,
            period = period,
        )
    }
    Canvas(
        modifier = modifier
            .fillMaxSize()
            .alpha(0.6f)
    ) {
        drawParticles(particlesModel)
    }
}