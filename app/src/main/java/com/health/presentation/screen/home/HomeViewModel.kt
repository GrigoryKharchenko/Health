package com.health.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import com.health.domain.repository.DataStoreRepository
import com.health.presentation.screen.addpfc.onStartedAddPfcScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
    private val router: Router
) : ViewModel() {

    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    init {
        getPfc()
    }

    fun perform(event: HomeViewEvent) {
        when (event) {
            HomeViewEvent.OpenAddPfcFragment -> openAddPfcFragment()
            HomeViewEvent.UpdateDailyPfc -> updateDailyPfc()
        }
    }

    private fun openAddPfcFragment() {
        router.navigateTo(onStartedAddPfcScreen())
    }

    private fun updateDailyPfc() {
        viewModelScope.launch {
            _state.update { state ->
                state.copy(
                    dailyCalories = dataStoreRepository.getDailyCalories().toString(),
                    dailyProtein = dataStoreRepository.getDailyProtein().toString(),
                    dailyFats = dataStoreRepository.getDailyFats().toString(),
                    dailyCarbs = dataStoreRepository.getDailyCrabs().toString()
                )
            }
        }
    }

    private fun getPfc() {
        viewModelScope.launch {
            with(dataStoreRepository) {
                _state.emit(
                    HomeViewState(
                        amountCalories = getCalories().toString(),
                        amountProtein = getProtein().toString(),
                        amountFats = getFats().toString(),
                        amountCrabs = getCrabs().toString(),
                        indexMass = getIndexMass().toString(),
                        purpose = getPurpose(),
                        dailyFats = getDailyFats().toString(),
                        dailyProtein = getDailyProtein().toString(),
                        dailyCalories = getDailyCalories().toString(),
                        dailyCarbs = getDailyCrabs().toString()
                    )
                )
            }
        }
    }
}
