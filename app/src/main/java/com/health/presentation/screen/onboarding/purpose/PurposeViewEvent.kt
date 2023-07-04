package com.health.presentation.screen.onboarding.purpose

sealed interface PurposeViewEvent {

    object OpenSymptomsDialogFragment : PurposeViewEvent
    object CheckPurposeGroupView : PurposeViewEvent
    object CheckSicknessGroup : PurposeViewEvent
}
