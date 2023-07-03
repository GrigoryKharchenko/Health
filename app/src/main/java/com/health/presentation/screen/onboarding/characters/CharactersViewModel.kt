package com.health.presentation.screen.onboarding.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import com.health.R
import com.health.presentation.screen.onboarding.purpose.onStartedPurposeScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class CharactersViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    private val _state = MutableStateFlow(CharactersViewState())
    val state = _state.asStateFlow()

    fun perform(event: CharactersViewEvent) {
        when (event) {
            is CharactersViewEvent.CheckValidation -> checkValidation(
                age = event.age,
                height = event.height,
                weight = event.weight
            )

            CharactersViewEvent.HideAgeError -> hideAgeError()
            CharactersViewEvent.HideHeightError -> hideHeightError()
            CharactersViewEvent.HideWeightError -> hideWeightError()
            CharactersViewEvent.OpenPurposeFragment -> openPurposeFragment()
        }
    }

    private fun checkValidation(
        age: String,
        height: String,
        weight: String
    ) {
        viewModelScope.launch {
            _state.emit(
                CharactersViewState(
                    ageError = if (age.isEmpty()) R.string.empty_error else R.string.empty,
                    heightError = if (height.isEmpty()) R.string.empty_error else R.string.empty,
                    weightError = if (weight.isEmpty()) R.string.empty_error else R.string.empty,
                )
            )
            if (age.isNotEmpty() && height.isNotEmpty() && weight.isNotEmpty()) {
                openPurposeFragment()
            }
        }
    }

    private fun hideAgeError() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(ageError = R.string.empty)
            }
        }
    }

    private fun hideHeightError() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(heightError = R.string.empty)
            }
        }
    }

    private fun hideWeightError() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(weightError = R.string.empty)
            }
        }
    }

    private fun openPurposeFragment() {
        router.navigateTo(onStartedPurposeScreen())
    }
}
