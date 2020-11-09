package com.rathiesh.countrydetail.di.module

import com.rathiesh.countrydetail.base.ViewModelActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ComposeModule {

    @ContributesAndroidInjector
    internal abstract fun contributeViewModelActivity(): ViewModelActivity
}