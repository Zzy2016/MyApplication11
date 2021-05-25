package com.example.appkotlin.net

import io.reactivex.Observable
import retrofit2.http.GET

interface ProjectApi {
    @GET("project/tree/json")
    suspend fun loadProjectTree(): BaseResp<List<ProjectTree>>

//    @GET("banner/json")
//    suspend fun getHomeBanner():
////    fun getBanner(): Observable<Banners?>?
}