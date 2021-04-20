package com.phro.initiativem

import android.app.Application
import com.phro.initiativem.di.characterModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(characterModule)
        }
    }

}