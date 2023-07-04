package com.health.presentation.screen.onboarding.purpose

sealed interface PurposeViewEvent {

    object OpenSymptomsFragment : PurposeViewEvent
    object CheckPurposeGroupView : PurposeViewEvent
    object CheckSicknessGroup : PurposeViewEvent
    object OpenNavViewFragment : PurposeViewEvent
    data class CalculatePfc(val purpose: String) : PurposeViewEvent
    object SetAuthorized : PurposeViewEvent
}
