package com.example.appkotlin.net

class BaseResponse<T> {
    private var errorCode = -1
    private var errorDesc = ""
    private var data: T? = null

}