package com.health.presentation.screen.onboarding.gender

sealed interface GenderEvent {

    object OpenDailyActivityFragment : GenderEvent

    data class SetGender(val gender: Int) : GenderEvent
}
