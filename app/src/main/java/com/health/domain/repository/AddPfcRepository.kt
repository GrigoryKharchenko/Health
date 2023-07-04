package com.health.domain.repository

interface AddPfcRepository {

    suspend fun addPfc(
        currentCalories: Int,
        currentProtein: Int,
        currentFats: Int,
        currentCrabs: Int
    )
}
