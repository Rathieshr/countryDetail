package com.rathiesh.countrydetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rathiesh.countrydetail.data.network.model.CountryResponse
import com.rathiesh.countrydetail.domain.repository.ICountryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

class CountryListViewModel @Inject constructor(private val mainRepository: ICountryRepository) :
    ViewModel() {

    val countryListLiveData:MutableLiveData<List<CountryResponse>> = MutableLiveData()
    val errorStateLiveData:MutableLiveData<String> = MutableLiveData()

    fun getDataFromRepo()  {
        CoroutineScope(IO).launch {
            try {
                val responseData = mainRepository.getAllCountries()
                countryListLiveData.postValue(responseData)
            }catch (e:Exception){
                errorStateLiveData.postValue("Error occurred, Please try again!!")
            }
        }
    }
}