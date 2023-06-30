package com.health.presentation.screen.onboarding.gender

import com.github.terrakok.cicerone.androidx.FragmentScreen

fun onStartedGenderScreen() = FragmentScreen {
    GenderFragment.newInstance()
}
