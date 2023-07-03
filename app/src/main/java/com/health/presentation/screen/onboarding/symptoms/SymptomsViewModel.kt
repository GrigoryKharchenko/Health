package com.health.presentation.screen.onboarding.symptoms

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class SymptomsViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    fun perform(event: SymptomsEvent) {
        when (event) {
            SymptomsEvent.GoBackScreen -> goBack()
        }
    }

    private fun goBack() {
        router.exit()
    }
}
