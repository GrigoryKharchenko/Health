package com.health.presentation.screen.navview

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.health.presentation.screen.home.onStartedHomeScreen
import javax.inject.Inject

class NavViewViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    fun perform(event: NavViewViewEvent) {
        when (event) {
            NavViewViewEvent.OpenHomeFragment -> openHomeFragment()
        }
    }

    private fun openHomeFragment() {
        router.replaceScreen(onStartedHomeScreen())
    }
}
