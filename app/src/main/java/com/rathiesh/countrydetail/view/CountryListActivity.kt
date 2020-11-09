package com.rathiesh.countrydetail.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.SearchView
import android.widget.SearchView.OnQueryTextListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rathiesh.countrydetail.R
import com.rathiesh.countrydetail.base.ViewModelActivity
import com.rathiesh.countrydetail.constants.INTENT_EXTRA_COUNTRY_DETAIL
import com.rathiesh.countrydetail.data.network.model.CountryResponse
import com.rathiesh.countrydetail.extenstion.showError
import com.rathiesh.countrydetail.util.NetworkUtil
import com.rathiesh.countrydetail.viewmodel.CountryListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class CountryListActivity : ViewModelActivity(),ICountryItemClickListener {

    private val mCountryListViewModel: CountryListViewModel by injectViewModels()
    lateinit var countryAdapter: CountryListRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress_circular.visibility = View.VISIBLE
        mCountryListViewModel.countryListLiveData.observe(this, Observer {
            processList(it)
        })
        mCountryListViewModel.errorStateLiveData.observe(this, Observer {
            showError(countryListContainer, it)
        })
        fetchCountries()
        country_search.setOnQueryTextListener(object: OnQueryTextListener, androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                countryAdapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun fetchCountries(){
        if(NetworkUtil.isNetworkAvailable(this)){
            mCountryListViewModel.getDataFromRepo()
        }else{
            progress_circular.visibility = View.GONE
            showError(countryListContainer, getString(R.string.network_error_message),
                    View.OnClickListener {
                        progress_circular.visibility = View.VISIBLE
                        fetchCountries()
                    })
        }
    }

    private fun processList(it: List<CountryResponse>?) {
        countryAdapter = CountryListRecyclerAdapter(this, this)
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        countryList.layoutManager = staggeredGridLayoutManager
        countryList.adapter = countryAdapter
        countryAdapter.setData(it)
        progress_circular.visibility = View.GONE
    }

    override fun onItemClick(country: CountryResponse) {
        val intent = Intent(this, CountryDetailActivity::class.java)
            intent.putExtra(INTENT_EXTRA_COUNTRY_DETAIL, country)
        startActivity(intent)
    }


}
