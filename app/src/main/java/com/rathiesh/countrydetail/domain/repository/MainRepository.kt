package com.rathiesh.countrydetail.domain.repository

import com.rathiesh.countrydetail.data.network.api.CountryService
import com.rathiesh.countrydetail.data.network.model.CountryResponse
import com.rathiesh.countrydetail.data.storage.dao.MainDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val mainDao: MainDao,
    val countryService: CountryService
) : ICountryRepository {

    override suspend fun getAllCountries(): List<CountryResponse>? {
        var listOfCountries : List<CountryResponse>? = ArrayList()
        val response = countryService.getAllCountries().execute()
        if(response.isSuccessful){
            listOfCountries = response.body()
        }
        return listOfCountries
    }
}