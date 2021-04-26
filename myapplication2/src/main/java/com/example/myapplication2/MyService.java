package com.example.myapplication2;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.e("Service-", "onBind");

        return new MyBinder();
    }



    class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
}