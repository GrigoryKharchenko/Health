package com.health.presentation.screen.onboarding.symptoms

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class SymptomsViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    fun perform(event: SymptomsViewEvent) {
        when (event) {
            SymptomsViewEvent.GoBack -> goBack()
        }
    }

    private fun goBack() {
        router.exit()
    }
}
