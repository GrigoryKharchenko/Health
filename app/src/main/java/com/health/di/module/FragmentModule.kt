package com.health.di.module

import com.health.presentation.screen.onboarding.dailyactivity.DailyActivityFragment
import com.health.presentation.screen.onboarding.gender.GenderFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun bindMainPageFragment(): GenderFragment

    @ContributesAndroidInjector
    fun bindDailyActivityFragment(): DailyActivityFragment
}
