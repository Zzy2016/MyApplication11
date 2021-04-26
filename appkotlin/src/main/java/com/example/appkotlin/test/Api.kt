package com.example.appkotlin.test

import retrofit2.Call
import retrofit2.http.GET

interface Api {
//    @GET("banner/json")
//    fun getBanner():Call<BannerModel>

    @GET("banner/json")
    suspend fun getBanner(): BannerModel


}