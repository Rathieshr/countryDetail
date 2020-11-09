package com.rathiesh.countrydetail.domain.repository

import com.rathiesh.countrydetail.data.network.model.CountryResponse

interface ICountryRepository : Repository {

    suspend fun getAllCountries() : List<CountryResponse>?
}