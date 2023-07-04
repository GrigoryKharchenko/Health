package com.health.presentation.screen.home

import com.github.terrakok.cicerone.androidx.FragmentScreen

fun onStartedHomeScreen() = FragmentScreen {
    HomeFragment.newInstance()
}
