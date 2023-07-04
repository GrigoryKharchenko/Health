package com.health.presentation.screen.activiti

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import com.health.domain.repository.DataStoreRepository
import com.health.presentation.screen.navview.onStartedNavViewScreen
import com.health.presentation.screen.onboarding.gender.onStartedGenderScreen
import com.health.presentation.util.DateUtil
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val router: Router,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    init {
        checkDate()
    }

    fun perform(event: MainEvent) {
        when (event) {
            MainEvent.StartScreen -> startScreen()
        }
    }

    private fun startScreen() {
        viewModelScope.launch {
            if (dataStoreRepository.isAuthorized()) {
                delay(100)
                router.newRootScreen(onStartedNavViewScreen())
            } else {
                router.newRootScreen(onStartedGenderScreen())
            }
        }
    }

    private fun checkDate() {
        viewModelScope.launch {
            if (dataStoreRepository.getDate() == DateUtil.getCurrentDate()) {
                dataStoreRepository.setDate(DateUtil.getCurrentDate())
            } else {
                dataStoreRepository.setDate(DateUtil.getCurrentDate())
                dataStoreRepository.setDailyCalories(0)
                dataStoreRepository.setDailyCrabs(0)
                dataStoreRepository.setDailyFats(0)
                dataStoreRepository.setDailyProtein(0)
            }
        }
    }
}
