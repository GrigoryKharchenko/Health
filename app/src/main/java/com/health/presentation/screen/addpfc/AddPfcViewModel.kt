package com.health.presentation.screen.addpfc

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import com.health.domain.repository.AddPfcRepository
import com.health.extension.toIntOrZero
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddPfcViewModel @Inject constructor(
    private val router: Router,
    private val addPfcRepository: AddPfcRepository
) : ViewModel() {

    fun perform(event: AddPfcViewEvent) {
        when (event) {
            AddPfcViewEvent.GoBack -> goBack()
            is AddPfcViewEvent.UpdatePfc -> updatePfc(
                event.calories,
                event.protein,
                event.fats,
                event.crabs
            )
        }
    }

    private fun updatePfc(
        calories: String,
        protein: String,
        fats: String,
        crabs: String
    ) {
        viewModelScope.launch {
            runCatching {
                addPfcRepository.addPfc(
                    currentCalories = calories.toIntOrZero(),
                    currentProtein = protein.toIntOrZero(),
                    currentFats = fats.toIntOrZero(),
                    currentCrabs = crabs.toIntOrZero()
                )
            }.onSuccess {
                goBack()
            }.onFailure {
                //TODO
            }
        }
    }

    private fun goBack() {
        router.exit()
    }
}
