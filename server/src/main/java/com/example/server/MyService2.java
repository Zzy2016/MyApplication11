package com.example.server;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService2 extends Service {
    public MyService2() {
    }

    public int count = 0;
    public boolean isStop=true;

    @Override
    public IBinder onBind(Intent intent) {

        return myBinder;
    }

    MyBinder myBinder = new MyBinder();

    class MyBinder extends Binder {
        public MyService2 getBinder() {
            return MyService2.this;
        }
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Service--", "onCreate");

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (isStop){
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }

                    count += 1;
                }
            }
        }).start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        isStop=false;
        Log.e("Service--", "onDestroy");
    }
}