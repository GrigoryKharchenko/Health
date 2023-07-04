package com.health.presentation.screen.navview

import com.github.terrakok.cicerone.androidx.FragmentScreen

fun onStartedNavViewScreen() = FragmentScreen {
    NavViewFragment.newInstance()
}
