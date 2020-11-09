package com.rathiesh.countrydetail.di

import android.app.Application
import com.rathiesh.countrydetail.CountryApplication
import com.rathiesh.countrydetail.di.module.ActivityBuilder
import com.rathiesh.countrydetail.di.module.ComposeModule
import com.rathiesh.countrydetail.di.module.PersistenceStorageModule
import com.rathiesh.countrydetail.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [AndroidInjectionModule::class,
        ActivityBuilder::class,
        ViewModelModule::class,
        ComposeModule::class,
        PersistenceStorageModule::class]
)
interface AppComponent : AndroidInjector<CountryApplication> {

    @Component.Factory
    interface Factory {
        fun application(@BindsInstance application: Application): AppComponent
    }

}