package com.health.presentation.screen.onboarding.dailyactivity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DailyActivityModel(
    val id: Int,
    val amountCalories: Int,
    @DrawableRes val iconActivity: Int,
    @StringRes val description: Int,
    val isSelected: Boolean = false
)
