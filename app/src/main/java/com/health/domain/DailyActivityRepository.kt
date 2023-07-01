package com.health.domain

import com.health.presentation.screen.onboarding.dailyactivity.DailyActivityModel

interface DailyActivityRepository {

    fun getDailyActivity(): List<DailyActivityModel>
}
