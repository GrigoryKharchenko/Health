package com.health.presentation.screen.onboarding.dailyactivity

sealed interface DailyActivityEvent {

    data class SelectDailyActivity(val dailyActivityId: Int) : DailyActivityEvent
}
