package com.rathiesh.countrydetail.data.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class CountryResponse(val name:String?, val flag:String?, val region: String?,
                           @SerializedName("subregion")
                           val subRegion:String?,
                           val nativeName: String?,
                           val population:Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(flag)
        parcel.writeString(region)
        parcel.writeString(subRegion)
        parcel.writeString(nativeName)
        parcel.writeInt(population)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CountryResponse> {
        override fun createFromParcel(parcel: Parcel): CountryResponse {
            return CountryResponse(parcel)
        }

        override fun newArray(size: Int): Array<CountryResponse?> {
            return arrayOfNulls(size)
        }
    }
}