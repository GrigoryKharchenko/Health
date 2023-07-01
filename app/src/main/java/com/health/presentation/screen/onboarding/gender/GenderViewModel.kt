package com.health.presentation.screen.onboarding.gender

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.health.presentation.screen.onboarding.dailyactivity.onStartedDailyActivityScreen
import javax.inject.Inject

class GenderViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    fun perform(event: GenderEvent) {
        when (event) {
            GenderEvent.OpenDailyActivityFragment -> openDailyActivityFragment()
        }
    }

    private fun openDailyActivityFragment() {
        router.navigateTo(onStartedDailyActivityScreen())
    }
}
