package com.health.presentation.screen.onboarding.symptoms

import com.github.terrakok.cicerone.androidx.FragmentScreen

fun startedSymptomsDialogFragment() = FragmentScreen {
    SymptomsFragment.newInstance()
}
