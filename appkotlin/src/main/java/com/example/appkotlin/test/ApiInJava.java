package com.example.appkotlin.test;

import retrofit2.http.GET;

public interface ApiInJava {
    @GET("banner/json")
    Object getBanner();
}
