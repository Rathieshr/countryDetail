package com.rathiesh.countrydetail

import android.annotation.SuppressLint
import com.rathiesh.countrydetail.di.DaggerAppComponent
import dagger.android.DaggerApplication

/**
 * This class is representation of [Application] and [DaggerApplication], It handles the global
 * Application state.
 */
@SuppressLint("Registered")
class CountryApplication : DaggerApplication() {

    /**
     * Instance of [DaggerAppComponent]
     */
    private val appComponent = DaggerAppComponent.factory().application(this)

    @SuppressWarnings("Unused")
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector() = appComponent
}