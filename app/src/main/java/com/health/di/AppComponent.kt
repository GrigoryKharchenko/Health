package com.health.di

import android.content.Context
import com.health.HealthApp
import com.health.di.module.ActivityModule
import com.health.di.module.FragmentModule
import com.health.di.module.InteractorModule
import com.health.di.module.NavigationModule
import com.health.di.module.RepositoryModule
import com.health.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class,
        NavigationModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        InteractorModule::class
    ]
)
interface AppComponent : AndroidInjector<HealthApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}
