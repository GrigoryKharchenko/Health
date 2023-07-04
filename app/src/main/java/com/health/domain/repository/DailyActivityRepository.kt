package com.health.domain.repository

import com.health.presentation.screen.onboarding.dailyactivity.DailyActivityModel

interface DailyActivityRepository {

    fun getDailyActivity(): List<DailyActivityModel>
}
