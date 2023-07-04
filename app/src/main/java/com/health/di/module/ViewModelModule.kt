package com.health.di.module

import androidx.lifecycle.ViewModel
import com.health.di.ViewModelKey
import com.health.presentation.screen.activiti.MainViewModel
import com.health.presentation.screen.addpfc.AddPfcViewModel
import com.health.presentation.screen.home.HomeViewModel
import com.health.presentation.screen.navview.NavViewViewModel
import com.health.presentation.screen.onboarding.characters.CharactersViewModel
import com.health.presentation.screen.onboarding.dailyactivity.DailyActivityViewModel
import com.health.presentation.screen.onboarding.gender.GenderViewModel
import com.health.presentation.screen.onboarding.purpose.PurposeViewModel
import com.health.presentation.screen.onboarding.symptoms.SymptomsViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    fun bindCharactersViewModel(viewModel: CharactersViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PurposeViewModel::class)
    fun bindPurposeViewModel(viewModel: PurposeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SymptomsViewModel::class)
    fun bindSymptomsViewModel(viewModel: SymptomsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NavViewViewModel::class)
    fun bindNavViewViewModel(viewModel: NavViewViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddPfcViewModel::class)
    fun bindAddPfcViewModel(viewModel: AddPfcViewModel): ViewModel
}
