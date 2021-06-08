package com.example.appkotlin.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


//class RetrofitManager private constructor() {
//    companion object {
////        private var retrofitManager: RetrofitManager? = null
////            get() {
////                if (field == null) {
////                    retrofitManager = RetrofitManager()
////                }
////                return field
////            }
//
//        private var retrofit: Retrofit? = null
//            get() {
//                if (field == null) {
//                    field = Retrofit.Builder().baseUrl("https://www.wanandroid.com").build()
//                }
//                return field
//            }
//
//        @Synchronized
//        fun getApi(): ProjectApi? {
//            return retrofit!!.create(ProjectApi::class.java)
//        }
//    }
//}


object RetrofitManager {
    private val mOkClient = OkHttpClient.Builder()
            .callTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .followRedirects(false)
            .build();

    private var mRetrofit: Retrofit? = null
    private fun initRetrofit(): RetrofitManager {
        mRetrofit = Retrofit.Builder().baseUrl("https://www.wanandroid.com")
                .client(mOkClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return this
    }

    fun  getService():ProjectApi{

        if (mRetrofit == null) {
            throw UninitializedPropertyAccessException("Retrofit exception")
        } else {
            return mRetrofit!!.create(ProjectApi::class.java)
        }
    }

}