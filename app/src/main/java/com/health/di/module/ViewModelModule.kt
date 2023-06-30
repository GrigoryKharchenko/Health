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
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GenderViewModel::class)
    abstract fun bindGenderViewModel(viewModel: GenderViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DailyActivityViewModel::class)
    abstract fun bindDailyActivityViewModel(viewModel: DailyActivityViewModel): ViewModel
}
