package com.health.presentation.screen.onboarding.purpose

import androidx.annotation.StringRes
import com.health.R

enum class Purposes(@StringRes val purpose: Int) {
    WEIGHT_LOSS(R.string.purpose_weight_loss),
    WEIGHT_SAVE(R.string.purpose_weight_save),
    WEIGHT_GAIN(R.string.purpose_weight_gain)
}
