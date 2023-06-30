package com.health.presentation.screen.onboarding.dailyactivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import com.health.domain.DailyActivityRepository
import com.health.presentation.screen.onboarding.characters.onStartedCharacterScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class DailyActivityViewModel @Inject constructor(
    private val dailyActivityRepository: DailyActivityRepository,
    private val router: Router
) : ViewModel() {

    private val _dailyActivityFlow = MutableStateFlow(DailyActivityViewState())
    val dailyActivityFlow = _dailyActivityFlow.asStateFlow()

    private var lastSelectedDailyActivityId: Int? = null

    init {
        getDailyActivity()
    }

    fun perform(event: DailyActivityEvent) {
        when (event) {
            is DailyActivityEvent.SelectDailyActivity -> selectDailyActivity(event.dailyActivityId)
            DailyActivityEvent.OpenCharacterFragment -> openCharacterFragment()
        }
    }

    private fun selectDailyActivity(dailyActivityId: Int) {
        val dailyActivities = _dailyActivityFlow.value.dailyActivities.map { dailyActivity ->
            when {
                dailyActivityId == lastSelectedDailyActivityId && dailyActivityId == dailyActivity.id ->
                    dailyActivity.copy(isSelected = !dailyActivity.isSelected)

                dailyActivity.id == dailyActivityId -> dailyActivity.copy(isSelected = true)
                dailyActivity.id == lastSelectedDailyActivityId -> dailyActivity.copy(isSelected = false)
                else -> dailyActivity
            }
        }
        lastSelectedDailyActivityId = dailyActivityId
        _dailyActivityFlow.update { state ->
            state.copy(
                dailyActivities = dailyActivities,
                //TODO переделать
                isVisibleBtnNext = dailyActivities.any { dailyActivity ->
                    dailyActivity.isSelected
                }
            )
        }
    }

    private fun openCharacterFragment() {
        router.navigateTo(onStartedCharacterScreen())
    }

    private fun getDailyActivity() {
        viewModelScope.launch {
            _dailyActivityFlow.emit(
                DailyActivityViewState(
                    dailyActivities = dailyActivityRepository.getDailyActivity(),
                )
            )
        }
    }
}
