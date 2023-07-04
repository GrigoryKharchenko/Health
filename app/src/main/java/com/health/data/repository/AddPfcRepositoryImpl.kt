package com.health.data.repository

import com.health.domain.repository.AddPfcRepository
import com.health.domain.repository.DataStoreRepository
import javax.inject.Inject

class AddPfcRepositoryImpl @Inject constructor(
    private val dataRepository: DataStoreRepository
) : AddPfcRepository {

    override suspend fun addPfc(
        currentCalories: Int,
        currentProtein: Int,
        currentFats: Int,
        currentCrabs: Int
    ) {
        with(dataRepository) {
            setDailyCalories(getDailyCalories() + currentCalories)
            setDailyProtein(getDailyProtein() + currentProtein)
            setDailyFats(getDailyFats() + currentFats)
            setDailyCrabs(getDailyCrabs() + currentCrabs)
        }
    }
}
