package com.example.admin.mykotlin1

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ADMIN on 5/26/2018.
 */
@Singleton
class NetManager @Inject constructor(var applicationContext: Context) {

    val isConnectedToInternet: Boolean?
        get() {

            val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                    as ConnectivityManager

            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
}