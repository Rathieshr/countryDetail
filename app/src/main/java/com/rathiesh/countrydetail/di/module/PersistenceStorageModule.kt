package com.rathiesh.countrydetail.di.module

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.rathiesh.countrydetail.data.network.api.CountryService
import com.rathiesh.countrydetail.data.storage.AppDataBase
import com.rathiesh.countrydetail.data.storage.dao.MainDao
import com.rathiesh.countrydetail.domain.repository.ICountryRepository
import com.rathiesh.countrydetail.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class PersistenceStorageModule {

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDataBase {
        return Room
            .databaseBuilder(application, AppDataBase::class.java, "Countries.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideMainDao(@NonNull appDataBase: AppDataBase): MainDao {
        return appDataBase.mainDao()
    }

    @Provides
    @Singleton
    fun providesRepository(mainDao: MainDao, countryService: CountryService
    ): ICountryRepository {
        return MainRepository(mainDao, countryService)
    }
}