package com.example.appkotlin.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class RetrofitTest constructor() {
    companion object {
        private var instance: Retrofit? = null
            get() {
                if (field == null) {
                    var okHttpClient: OkHttpClient = OkHttpClient.Builder().callTimeout(60, TimeUnit.SECONDS).build()
                    field = Retrofit.Builder().baseUrl("https://wanandroid.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(okHttpClient)
                            .build()
                }
                return field
            }

//        @Synchronized
//        fun get(): Retrofit {
//            return instance!!
//        }
        @Synchronized
        fun getApi(): Api? {
            return instance?.create(Api::class.java)
        }
    }




}

