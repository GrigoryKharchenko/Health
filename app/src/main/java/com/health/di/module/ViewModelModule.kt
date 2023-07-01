package com.health.di.module

import androidx.lifecycle.ViewModel
import com.health.di.ViewModelKey
import com.health.presentation.screen.activiti.MainViewModel
import com.health.presentation.screen.onboarding.dailyactivity.DailyActivityViewModel
import com.health.presentation.screen.onboarding.gender.GenderViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GenderViewModel::class)
    fun bindGenderViewModel(viewModel: GenderViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DailyActivityViewModel::class)
    fun bindDailyActivityViewModel(viewModel: DailyActivityViewModel): ViewModel
}
