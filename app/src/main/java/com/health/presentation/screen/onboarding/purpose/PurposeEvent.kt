package com.health.presentation.screen.onboarding.purpose

sealed interface PurposeEvent {

    object OpenSymptomsDialogFragment : PurposeEvent
    object CheckPurposeGroup : PurposeEvent
    object CheckSicknessGroup : PurposeEvent
}
