package com.example.myapplication11.manager;

import android.app.Activity;

import java.lang.ref.WeakReference;

public class MyActivityManager {
    private static MyActivityManager sInstance=new MyActivityManager();
    private WeakReference<Activity> sCurrentActivityWeakRef;


    public MyActivityManager() {
    }

    public static MyActivityManager getsInstance() {
        return sInstance;
    }

    public Activity getsCurrentActivityWeakRef() {
        Activity currentActivity=null;
        if(sCurrentActivityWeakRef!=null){
            currentActivity=sCurrentActivityWeakRef.get();
        }
        return currentActivity;
    }

    public void setsCurrentActivityWeakRef(Activity activity) {
        this.sCurrentActivityWeakRef =new WeakReference<>(activity);
    }
}
