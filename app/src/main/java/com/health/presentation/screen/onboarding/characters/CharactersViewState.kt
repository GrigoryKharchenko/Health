package com.health.presentation.screen.onboarding.characters

import androidx.annotation.StringRes
import com.health.R

data class CharactersViewState(
    @StringRes val ageError: Int = R.string.empty,
    @StringRes val heightError: Int = R.string.empty,
    @StringRes val weightError: Int = R.string.empty
)
