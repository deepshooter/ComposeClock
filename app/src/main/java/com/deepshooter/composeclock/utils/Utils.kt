package com.deepshooter.composeclock.utils

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.deepshooter.composeclock.models.ParticlesModel
import java.util.concurrent.TimeUnit
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin
import kotlin.random.Random


const val PI = kotlin.math.PI.toFloat()
const val PI_DIV_2 = PI / 2f
val LocalRandom = compositionLocalOf { Random(System.currentTimeMillis()) }
val LocalSystemClock = compositionLocalOf<SystemClock> { SystemClockImpl() }

fun Random.nextFloat(start: Float, end: Float) = start + nextFloat() * (end - start)


fun DrawScope.drawParticles(particlesModel: ParticlesModel) {
    particlesModel.states.forEach {
        drawParticle(it, particlesModel.angleOffset)
    }
}

fun DrawScope.drawParticle(state: ParticlesModel.State, angleOffset: Float) {
    val radius = min(center.x, center.y)
    drawCircle(
        color = Color.White,
        center = Offset(
            center.x + radius * state.offset * cos(state.angle + angleOffset),
            center.y + radius * state.offset * sin(state.angle + angleOffset),
        ),
        style = state.drawStyle,
        radius = state.particleSize,
        alpha = state.alpha,
    )
}

fun Long.toMinuteRadians() =
    PI * ((TimeUnit.MILLISECONDS.toMinutes(this) % 60
            + ((TimeUnit.MILLISECONDS.toSeconds(this) % 60) / 60f)) / 30f) + PI_DIV_2

fun Long.toHourRadians(systemClock: SystemClock) =
    PI * ((systemClock.getHour()
            + ((TimeUnit.MILLISECONDS.toMinutes(this) % 60) / 60f)
            + ((TimeUnit.MILLISECONDS.toSeconds(this) % 60) / 3600f)) / 6f) - PI_DIV_2