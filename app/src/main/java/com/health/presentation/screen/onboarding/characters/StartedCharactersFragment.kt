package com.health.presentation.screen.onboarding.characters

import com.github.terrakok.cicerone.androidx.FragmentScreen

fun onStartedCharacterScreen() = FragmentScreen {
    CharactersFragment.newInstance()
}
