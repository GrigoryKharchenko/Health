package com.health.data

import com.health.R
import com.health.domain.DailyActivityRepository
import com.health.presentation.screen.onboarding.dailyactivity.DailyActivityModel
import javax.inject.Inject

class DailyActivityRepositoryImpl @Inject constructor() : DailyActivityRepository {

    override fun getDailyActivity(): List<DailyActivityModel> =
        listOf(
            DailyActivityModel(
                id = 0,
                amountCalories = 1200,
                iconActivity = R.drawable.ic_min_activity,
                description = R.string.description_min,
                isSelected = false
            ),
            DailyActivityModel(
                id = 1,
                amountCalories = 1375,
                iconActivity = R.drawable.ic_pre_min_activity,
                description = R.string.description_pre_min,
                isSelected = false
            ),
            DailyActivityModel(
                id = 2,
                amountCalories = 1550,
                iconActivity = R.drawable.ic_average_activity,
                description = R.string.description_average,
                isSelected = false
            ),
            DailyActivityModel(
                id = 3,
                amountCalories = 1725,
                iconActivity = R.drawable.ic_pre_max_activity,
                description = R.string.description_pre_max,
                isSelected = false
            ),
            DailyActivityModel(
                id = 4,
                amountCalories = 1900,
                iconActivity = R.drawable.ic_max_activity,
                description = R.string.description_max,
                isSelected = false
            ),
        )
}
