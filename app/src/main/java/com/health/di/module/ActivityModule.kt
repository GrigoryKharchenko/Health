package com.health.di.module

import com.health.presentation.screen.activiti.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector
    fun provideMainActivity(): MainActivity
}
