package com.health.di.module

import com.health.presentation.screen.addpfc.AddPfcFragment
import com.health.presentation.screen.home.HomeFragment
import com.health.presentation.screen.navview.NavViewFragment
import com.health.presentation.screen.onboarding.characters.CharactersFragment
import com.health.presentation.screen.onboarding.dailyactivity.DailyActivityFragment
import com.health.presentation.screen.onboarding.gender.GenderFragment
import com.health.presentation.screen.onboarding.purpose.PurposeFragment
import com.health.presentation.screen.onboarding.symptoms.SymptomsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentModule {

    @ContributesAndroidInjector
    fun bindMainPageFragment(): GenderFragment

    @ContributesAndroidInjector
    fun bindDailyActivityFragment(): DailyActivityFragment

    @ContributesAndroidInjector
    fun bindCharactersFragment(): CharactersFragment

    @ContributesAndroidInjector
    fun bindPurposeFragment(): PurposeFragment

    @ContributesAndroidInjector
    fun bindSymptomsFragment(): SymptomsFragment

    @ContributesAndroidInjector
    fun bindNavViewFragment(): NavViewFragment

    @ContributesAndroidInjector
    fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    fun bindAddPfcFragment(): AddPfcFragment
}
