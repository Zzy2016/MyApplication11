package com.example.appkotlin.net

import com.example.appkotlin.test.BannerModel
import retrofit2.http.GET

interface Api {
//    @GET("banner/json")
//    fun getBanner():Call<BannerModel>

    @GET("banner/json")
    suspend fun getBanner(): BannerModel


}