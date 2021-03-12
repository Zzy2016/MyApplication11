package com.example.appkotlin.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.appkotlin.MyApplication
import okhttp3.internal.waitMillis


class NetUtils {

    companion object {

        //        @RequiresApi(Build.VERSION_CODES.M)
        fun isConnect(): Boolean {
            var connect = MyApplication.CONTEXT.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        connect.getNetworkCapabilities()
//        connect.getLinkProperties()
//        connect.

//        ConnectivityManager.NetworkCallback
//        ConnectivityManager#getNetworkCapabilities
//        ConnectivityManager#getLinkProperties
//
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//                    connect.getNetworkCapabilities(connect.activeNetwork).toString()
//                }
//            }
//            return connect.getNetworkCapabilities(connect.activeNetwork).toString().contains("VALIDATED")


            return connect.activeNetworkInfo != null && connect.activeNetworkInfo?.isAvailable == true

        }

        //getActiveNetwork 当前NetWork与当前活动的默认数据网络相对应的对象
        //getActiveNetworkInfo 当前活动对象的默认数据网络的详细信息
    }


}