package com.health.presentation.screen.onboarding.purpose

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import com.health.presentation.screen.onboarding.symptoms.startedSymptomsDialogFragment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class PurposeViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    private val _state = MutableStateFlow(PurposeViewState())
    val state = _state.asStateFlow()

    fun perform(event: PurposeEvent) {
        when (event) {
            PurposeEvent.OpenSymptomsDialogFragment -> openSymptomsDialogFragment()
            PurposeEvent.CheckPurposeGroup -> checkPurposeGroup()
            PurposeEvent.CheckSicknessGroup -> checkSicknessGroup()
        }
    }

    private fun openSymptomsDialogFragment() {
        router.navigateTo(startedSymptomsDialogFragment())
    }

    private fun checkPurposeGroup() {
        _state.update { state ->
            state.copy(
                isEnabledPurposeGroup = true,
                isVisibleNextButton = state.isEnabledSicknessGroup,
            )
        }
    }

    private fun checkSicknessGroup() {
        _state.update { state ->
            state.copy(
                isEnabledSicknessGroup = true,
                isVisibleNextButton = state.isEnabledPurposeGroup
            )
        }
    }
}
