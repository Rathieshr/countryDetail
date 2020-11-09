package com.rathiesh.countrydetail.view

import com.rathiesh.countrydetail.data.network.model.CountryResponse

interface ICountryItemClickListener {
    fun onItemClick(country: CountryResponse)
}