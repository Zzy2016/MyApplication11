package com.example.appkotlin.test;

import android.util.Log;

public class SingleTest {

    private static SingleTest singleTest;

    public static SingleTest getSingleTest() {
        if (singleTest == null) {
            singleTest = new SingleTest();
        }


        return singleTest;
    }
}
