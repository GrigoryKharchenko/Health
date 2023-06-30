package com.health.di.module

import com.health.data.DailyActivityRepositoryImpl
import com.health.domain.DailyActivityRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun bindAllCategoryRepository(impl: DailyActivityRepositoryImpl): DailyActivityRepository
}
