package com.redbussearch.network.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import com.redbussearch.network.NetworkSDK

/**
 * @Author rahulravindran
 */
object NetworkUtils {
    @SuppressLint("MissingPermission")
    fun isNetworkConnected(): Boolean {
        val connectionManager = NetworkSDK.mContext?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectionManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }


}