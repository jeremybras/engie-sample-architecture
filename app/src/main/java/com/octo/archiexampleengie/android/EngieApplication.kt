package com.octo.archiexampleengie.android

import android.app.Application
import android.content.Context
import android.databinding.DataBindingUtil
import com.facebook.stetho.Stetho
import com.jakewharton.threetenabp.AndroidThreeTen
import com.octo.archiexampleengie.android.common.binding.BindingComponentImpl
import timber.log.Timber


class EngieApplication : Application() {

    companion object {
        fun getComponent(context: Context): MainComponent = (context.applicationContext as EngieApplication).component
    }

    private lateinit var component: MainComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerMainComponent.builder().mainModule(MainModule(this)).build()

        AndroidThreeTen.init(this)
        DataBindingUtil.setDefaultComponent(BindingComponentImpl())
        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())
    }
}
