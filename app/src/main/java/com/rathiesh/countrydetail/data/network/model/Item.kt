package com.rathiesh.countrydetail.data.network.model

import com.google.gson.annotations.SerializedName

data class Item (val name:String?,
                 val flag:String?,
                 val region: String?,
                 val subRegion:String?,
                 val nativeName: String?,
                 val population:Int,
                 val imageRatio: Float,
                 var columns: Int = 0)
