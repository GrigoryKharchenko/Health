package com.health

import com.health.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class HealthApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent
            .builder()
            .context(this)
            .build()
}
