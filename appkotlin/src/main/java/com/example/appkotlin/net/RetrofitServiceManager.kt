package com.example.appkotlin.net

import android.content.Context
import retrofit2.Retrofit

class RetrofitServiceManager {
    lateinit var context: Context
    private lateinit var mRetrofit: Retrofit
    private val DEFAULT_TIME_OUT:Long = 30L
//    companion object{
//        val base_url="https://wanandroid.com/"
//        val instance:RetrofitServiceManager lazy
//    }
}