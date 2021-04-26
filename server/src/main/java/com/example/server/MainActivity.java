package com.example.server;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


//

    private MyService2.MyBinder binder;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (MyService2.MyBinder) service;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (binder.getBinder().isStop){
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {

                        }

                        Log.e("Service--count", binder.getBinder().count + "");
                    }
                }
            }).start();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService2.class);
                bindService(intent, connection, Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService2.class);
                unbindService(connection);
            }
        });

    }
}