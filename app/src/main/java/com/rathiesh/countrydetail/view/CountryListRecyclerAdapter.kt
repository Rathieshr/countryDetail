package com.rathiesh.countrydetail.view

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrosid.svgloader.SvgLoader
import com.rathiesh.countrydetail.R
import com.rathiesh.countrydetail.data.network.model.CountryResponse
import kotlinx.android.synthetic.main.list_item_country.view.*
import java.util.*
import kotlin.collections.ArrayList

class CountryListRecyclerAdapter(val context: Context,val listener:ICountryItemClickListener) :
    RecyclerView.Adapter<CountryListRecyclerAdapter.CountryViewHolder>(),Filterable {

    var country: List<CountryResponse>? = null
    var countryFilterList : List<CountryResponse>? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_country, parent, false),listener
        )
    }

    override fun getItemCount(): Int = countryFilterList!!.size

    override fun onBindViewHolder(contryViewHolder: CountryViewHolder, position: Int) {
        contryViewHolder.bindView(context,countryFilterList!![position])

    }

    fun setData(country: List<CountryResponse>?) {
        this.country = country;
        countryFilterList = country
    }

    class CountryViewHolder(itemView: View,val listener: ICountryItemClickListener) : RecyclerView.ViewHolder(itemView){
        fun bindView(context: Context,country:CountryResponse){
            itemView.countryName.text = country.name
            SvgLoader.pluck()
                .with(context as Activity)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(country.flag, itemView.countryFlag)
            itemView.setOnClickListener {
                listener.onItemClick(country)
            }
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    countryFilterList = country
                } else {
                    val resultList = ArrayList<CountryResponse>()
                    for (row in country!!) {
                        if (row.name!!.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row)
                        }
                    }
                    countryFilterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = countryFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                countryFilterList = results?.values as List<CountryResponse>
                notifyDataSetChanged()
            }

        }
    }

}