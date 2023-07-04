package com.health.presentation.screen.home

sealed interface HomeViewEvent {

    object OpenAddPfcFragment : HomeViewEvent
    object UpdateDailyPfc : HomeViewEvent
}
