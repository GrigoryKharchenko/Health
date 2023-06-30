package com.health.presentation.screen.activiti

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.health.presentation.screen.onboarding.gender.onStartedGenderScreen
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    fun perform(event: MainEvent) {
        when (event) {
            MainEvent.StartScreen -> startScreen()
        }
    }

    private fun startScreen() {
        router.newRootScreen(onStartedGenderScreen())
    }
}
