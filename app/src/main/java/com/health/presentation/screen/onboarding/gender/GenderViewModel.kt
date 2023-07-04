package com.health.presentation.screen.onboarding.gender

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import com.health.domain.repository.DataStoreRepository
import com.health.presentation.screen.onboarding.dailyactivity.onStartedDailyActivityScreen
import kotlinx.coroutines.launch
import javax.inject.Inject

class GenderViewModel @Inject constructor(
    private val router: Router,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    fun perform(event: GenderEvent) {
        when (event) {
            GenderEvent.OpenDailyActivityFragment -> openDailyActivityFragment()
            is GenderEvent.SetGender -> setGender(event.gender)
        }
    }

    private fun openDailyActivityFragment() {
        router.navigateTo(onStartedDailyActivityScreen())
    }

    private fun setGender(gender: Int) {
        viewModelScope.launch {
            dataStoreRepository.setGender(gender)
        }
    }
}
