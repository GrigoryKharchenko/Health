package com.health.presentation.screen.onboarding.dailyactivity

sealed interface DailyActivityEvent {

    data class SelectDailyActivity(val dailyActivityId: Int) : DailyActivityEvent

    object OpenCharacterFragment : DailyActivityEvent

    data class SetActivityCoefficient(val activityCoefficient: Double) : DailyActivityEvent
}
