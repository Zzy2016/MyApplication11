package com.example.myapplication11.http.data;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class HttpBaseResponse<T> implements Serializable {
    @Expose
    public int errorCode;

    @Expose
    public String errorMsg;

    @Expose
    public T data;
}
