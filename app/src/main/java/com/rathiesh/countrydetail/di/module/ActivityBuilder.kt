package com.rathiesh.countrydetail.di.module

import com.rathiesh.countrydetail.view.CountryListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    internal abstract fun contributeCountryListActivity(): CountryListActivity

}