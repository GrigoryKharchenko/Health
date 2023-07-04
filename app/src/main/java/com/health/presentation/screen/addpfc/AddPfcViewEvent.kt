package com.health.presentation.screen.addpfc

sealed interface AddPfcViewEvent {

    object GoBack : AddPfcViewEvent

    data class UpdatePfc(
        val calories: String,
        val protein: String,
        val fats: String,
        val crabs: String
    ) : AddPfcViewEvent
}