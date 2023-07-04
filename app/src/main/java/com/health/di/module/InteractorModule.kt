package com.health.di.module

import com.health.data.interactor.PurposeInteractorImpl
import com.health.domain.interactor.PurposeInteractor
import dagger.Binds
import dagger.Module

@Module
interface InteractorModule {

    @Binds
    fun bindPurposeInteractor(impl: PurposeInteractorImpl): PurposeInteractor
}
