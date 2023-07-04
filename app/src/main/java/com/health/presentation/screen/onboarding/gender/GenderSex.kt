package com.health.presentation.screen.onboarding.gender

import androidx.annotation.StringRes
import com.health.R

enum class GenderSex(@StringRes val sex: Int) {
    MAN(R.string.gender_man),
    WOMAN(R.string.gender_woman)
}
