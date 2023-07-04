package com.health.di.module

import com.health.data.repository.AddPfcRepositoryImpl
import com.health.data.repository.DailyActivityRepositoryImpl
import com.health.data.repository.DataStoreRepositoryImpl
import com.health.domain.repository.AddPfcRepository
import com.health.domain.repository.DailyActivityRepository
import com.health.domain.repository.DataStoreRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindAllCategoryRepository(impl: DailyActivityRepositoryImpl): DailyActivityRepository

    @Binds
    fun bindDataStoreRepository(impl: DataStoreRepositoryImpl): DataStoreRepository

    @Binds
    fun bindAddPfcRepository(impl: AddPfcRepositoryImpl): AddPfcRepository
}
