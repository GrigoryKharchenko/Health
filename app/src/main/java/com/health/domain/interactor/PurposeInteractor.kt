package com.health.domain.interactor

interface PurposeInteractor {

    suspend fun calculatePfc(purpose: String)
}
