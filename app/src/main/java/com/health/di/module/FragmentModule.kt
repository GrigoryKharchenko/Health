package com.health.di.module

import com.health.presentation.screen.onboarding.GenderFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun bindMainPageFragment(): GenderFragment
}
