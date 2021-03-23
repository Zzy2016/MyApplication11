package com.example.appkotlin.net

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GetRetrofit {

    lateinit var retrofit: Retrofit


    companion object Factory {
        var okHttpClient = OkHttpClient.Builder().build()


        fun getInstance():Unit{

        }

    }




}