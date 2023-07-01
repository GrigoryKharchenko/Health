package com.health.presentation.screen.onboarding.dailyactivity

import com.github.terrakok.cicerone.androidx.FragmentScreen

fun onStartedDailyActivityScreen() = FragmentScreen {
    DailyActivityFragment.newInstance()
}
