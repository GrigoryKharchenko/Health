package com.health.presentation.screen.onboarding.purpose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import com.health.domain.interactor.PurposeInteractor
import com.health.domain.repository.DataStoreRepository
import com.health.presentation.screen.navview.onStartedNavViewScreen
import com.health.presentation.screen.onboarding.purpose.PurposeViewEvent.CalculatePfc
import com.health.presentation.screen.onboarding.purpose.PurposeViewEvent.CheckPurposeGroupView
import com.health.presentation.screen.onboarding.purpose.PurposeViewEvent.CheckSicknessGroup
import com.health.presentation.screen.onboarding.purpose.PurposeViewEvent.OpenNavViewFragment
import com.health.presentation.screen.onboarding.purpose.PurposeViewEvent.OpenSymptomsFragment
import com.health.presentation.screen.onboarding.purpose.PurposeViewEvent.SetAuthorized
import com.health.presentation.screen.onboarding.symptoms.startedSymptomsDialogFragment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class PurposeViewModel @Inject constructor(
    private val router: Router,
    private val dataStoreRepository: DataStoreRepository,
    private val purposeInteractor: PurposeInteractor
) : ViewModel() {

    private val _state = MutableStateFlow(PurposeViewState())
    val state = _state.asStateFlow()

    fun perform(event: PurposeViewEvent) {
        when (event) {
            OpenSymptomsFragment -> openSymptomsFragment()
            CheckPurposeGroupView -> checkPurposeGroup()
            CheckSicknessGroup -> checkSicknessGroup()
            OpenNavViewFragment -> openNavViewFragment()
            is CalculatePfc -> calculatePfc(event.purpose)
            SetAuthorized -> setAuthorized()
        }
    }

    private fun openSymptomsFragment() {
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

    private fun openNavViewFragment() {
        router.newRootChain(onStartedNavViewScreen())
    }

    private fun setAuthorized() {
        viewModelScope.launch {
            dataStoreRepository.setAuthorized(true)
        }
    }

    private fun calculatePfc(purpose: String) {
        viewModelScope.launch {
            purposeInteractor.calculatePfc(purpose)
        }
    }
}
