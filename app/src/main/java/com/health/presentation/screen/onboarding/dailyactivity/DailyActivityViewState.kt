package com.health.presentation.screen.onboarding.dailyactivity

data class DailyActivityViewState(
    val dailyActivities: List<DailyActivityModel> = emptyList(),
    val isVisibleBtnNext: Boolean = false
)
