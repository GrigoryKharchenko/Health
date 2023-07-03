package com.health.presentation.screen.onboarding.characters

sealed interface CharactersViewEvent {

    data class CheckValidation(
        val age: String,
        val height: String,
        val weight: String
    ) : CharactersViewEvent

    object HideAgeError : CharactersViewEvent
    object HideHeightError : CharactersViewEvent
    object HideWeightError : CharactersViewEvent
}
