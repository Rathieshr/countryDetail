package com.rathiesh.countrydetail.util

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService


object NetworkUtil {
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            getSystemService(context,ConnectivityManager::class.java)
        val activeNetworkInfo = connectivityManager!!.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}