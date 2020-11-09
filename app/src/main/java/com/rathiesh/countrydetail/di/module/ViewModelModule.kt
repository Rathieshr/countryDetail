package com.rathiesh.countrydetail.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rathiesh.countrydetail.di.AppViewModelFactory
import com.rathiesh.countrydetail.di.annotation.ViewModelKey
import com.rathiesh.countrydetail.viewmodel.CountryListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CountryListViewModel::class)
    internal abstract fun bindMainActivityViewModels(countryListViewModel: CountryListViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory
}