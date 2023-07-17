package com.deepshooter.composeclock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.deepshooter.composeclock.ui.components.ClockHourAndMinuteMarks
import com.deepshooter.composeclock.ui.components.ClockHoursHand
import com.deepshooter.composeclock.ui.components.ClockMinutesHand
import com.deepshooter.composeclock.ui.components.ClockParticles
import com.deepshooter.composeclock.ui.components.ClockSecondsHand
import com.deepshooter.composeclock.ui.components.ClockSphere
import com.deepshooter.composeclock.ui.theme.BlueGrey
import com.deepshooter.composeclock.ui.theme.ComposeClockTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ComposeClockTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(color = Color.Transparent)
                }
                Clock(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BlueGrey)
                )
            }
        }
    }
}


@Composable
fun Clock(
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {

        ClockSphere()
        ClockHourAndMinuteMarks()
        ClockParticles()
        ClockHoursHand()
        ClockMinutesHand()
        ClockSecondsHand()

    }
}