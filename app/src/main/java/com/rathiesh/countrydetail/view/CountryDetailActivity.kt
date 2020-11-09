package com.rathiesh.countrydetail.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ahmadrosid.svgloader.SvgLoader
import com.rathiesh.countrydetail.R
import com.rathiesh.countrydetail.constants.INTENT_EXTRA_COUNTRY_DETAIL
import com.rathiesh.countrydetail.data.network.model.CountryResponse
import com.rathiesh.countrydetail.extenstion.showError
import com.rathiesh.countrydetail.util.NetworkUtil
import kotlinx.android.synthetic.main.activity_country_detail.*
import kotlinx.android.synthetic.main.content_country_detail.*

class CountryDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_detail)
        val country = getCountryFromIntent()
        setSupportActionBar(toolbar)
        setCountryDetails(country)
    }

    private fun setCountryDetails(country: CountryResponse?) {
        title = country?.name
        SvgLoader.pluck()
            .with(this)
            .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
            .load(country?.flag, countryFlag_Image)
        regionValue.text = country?.region
        subRegionValue.text = country?.subRegion
        nativeNameValue.text = country?.nativeName
        populationValue.text = country?.population.toString()
    }

    private fun getCountryFromIntent() =
        intent.getParcelableExtra<CountryResponse>(INTENT_EXTRA_COUNTRY_DETAIL)
}
