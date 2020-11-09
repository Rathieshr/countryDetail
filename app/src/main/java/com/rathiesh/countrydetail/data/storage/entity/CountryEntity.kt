package com.rathiesh.countrydetail.data.storage.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class CountryEntity(@PrimaryKey
                         val name:String,
                         val flag:String,
                         val region: String,
                         val subRegion:String,
                         val population:Int) : Parcelable