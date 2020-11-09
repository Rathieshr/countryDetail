package com.rathiesh.countrydetail.data.network.api

import com.rathiesh.countrydetail.data.network.model.CountryResponse
import retrofit2.Call
import retrofit2.http.GET

interface CountryService {

    @GET("all")
    fun getAllCountries() : Call<List<CountryResponse>>
}